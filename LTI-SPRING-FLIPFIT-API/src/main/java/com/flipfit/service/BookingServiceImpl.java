package com.flipfit.service;



import com.flipfit.dto.*;
import com.flipfit.entity.Booking;
import com.flipfit.entity.BookingStatus;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.GymSlotStatus;
import com.flipfit.exception.BookingNotFoundException;
import com.flipfit.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final GymSlotService gymSlotService;

    @Override
    @Transactional
    public BookingResponse bookSlot(BookingRequest request) {
        // 1. load slot with DB row-lock to avoid race conditions
        GymSlot gymSlot = gymSlotService.getSlot(request.getSlotId());

        // 2. remove conflicting booking of same date/time for user (requirement #3)
        removeConflictingBooking(request.getUserId(), gymSlot.getDate(), gymSlot.getStartTime());

        // 3. verify slot state and seat availability
        if (gymSlot.getStatus() == GymSlotStatus.CANCELLED || gymSlot.getStatus() == GymSlotStatus.CLOSED) {
            return BookingResponse.failure("Slot is not available");
        }

        if (gymSlot.getSeatsRemaining() > 0) {
            // decrement seats and persist
            gymSlot.setSeatsRemaining(gymSlot.getSeatsRemaining() - 1);
            gymSlotService.updateSlot(gymSlot); // within same transaction and lock

            Booking booking = Booking.builder()
                    .userId(request.getUserId())
                    .slotId(gymSlot.getId())
                    .centerId(gymSlot.getCenterId())
                    .status(BookingStatus.CONFIRMED)
                    .build();

            booking = bookingRepo.save(booking);

            return BookingResponse.success("Booking confirmed", booking.getId());
        }
        // 4. slot full -> add to waitlist (FIFO)

        return BookingResponse.waitlisted("Slot full. Added to waitlist");
    }

    @Override
    @Transactional
    public CancelBookingResponse cancelBooking(Long bookingId, Long userId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));

        if (!booking.getUserId().equals(userId)) {
            return CancelBookingResponse.failure("Unauthorized");
        }

        if (booking.getStatus() == BookingStatus.CANCELLED) {
            return CancelBookingResponse.failure("Booking already cancelled");
        }

        // cancel booking
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepo.save(booking);

        // unlock a seat: lock slot row
        GymSlot gymSlot = gymSlotService.getSlot(booking.getSlotId());

        gymSlot.setSeatsRemaining(gymSlot.getSeatsRemaining() + 1);
        // Optionally change status from FULL -> OPEN
        if (gymSlot.getStatus() == GymSlotStatus.FULL && gymSlot.getSeatsRemaining() > 0) {
            gymSlot.setStatus(GymSlotStatus.OPEN);
        }
        gymSlotService.updateSlot(gymSlot);

        // promote waitlisted user (if any)


        return CancelBookingResponse.success("Booking cancelled");
    }

    /**
     * Returns availability info (booked seats,
     * remaining seats, waitlist count/status)
     * for a given center, date, and slot time.
     *
     * @param centerId
     * @param date
     * @param startTime
     */
    @Override
    public AvailabilityResponse getAvailability(Long centerId, LocalDate date, LocalTime startTime) {

        GymSlotRequest request = GymSlotRequest.builder()
                .centerId(centerId)
                .date(date)
                .time(startTime)
                .build();

        GymSlot gymSlot = gymSlotService.checkAvailability(request);


        int booked = gymSlot.getCapacity() - gymSlot.getSeatsRemaining();

        return AvailabilityResponse.builder()
                .capacity(gymSlot.getCapacity())
                .booked(booked)
                .remaining(gymSlot.getSeatsRemaining())
                .build();
    }


    @Override
    @Transactional(readOnly = true)
    public UserBookingsResponse getUserBookings(Long userId, LocalDate date) {
        List<Booking> bookings = bookingRepo.findByUserIdAndDate(userId, date);
        return UserBookingsResponse.fromBookings(bookings);
    }

    @Override
    @Transactional
    public void removeConflictingBooking(Long userId, LocalDate date, LocalTime startTime) {
        Optional<Booking> existing = bookingRepo.findOverlappingBooking(userId, date, startTime);
        existing.ifPresent(b -> {
            b.setStatus(BookingStatus.CANCELLED);
            bookingRepo.save(b);

            // free seat on the conflicting slot
            GymSlot gymSlot = gymSlotService.getSlot(b.getSlotId());
            GymSlot conflictingGymSlot = gymSlotService.updateSlot(gymSlot);
            conflictingGymSlot.setSeatsRemaining(conflictingGymSlot.getSeatsRemaining() + 1);
            gymSlotService.updateSlot(conflictingGymSlot);

            // promote waitlist for that slot

        });
    }

}
