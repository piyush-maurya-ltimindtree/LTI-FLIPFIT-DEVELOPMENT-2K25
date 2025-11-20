package com.lti.flipfit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.exception.BookingNotFoundException;
import com.lti.flipfit.exception.BookingOperationException;
/**
 * @author Mayuresh Arvind Gujar
 */
@Service
public class GymCustomerServiceImpl implements GymCustomerService {
    private final List<Booking> bookings = new ArrayList<>();

    public GymCustomerServiceImpl() {
        bookings.add(new Booking(1L, 1L, 1L, "Successful"));
        bookings.add(new Booking(2L, 2L, 2L, "Successful"));
        bookings.add(new Booking(3L, 3L, 3L, "Successful"));
        bookings.add(new Booking(4L, 4L, 4L, "Cancelled"));
        bookings.add(new Booking(5L, 5L, 5L, "Successful"));
    }

    @Override
    public List<Booking> viewBookings() {
        return bookings;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        if (bookingId == null) {
            throw new IllegalArgumentException("bookingId must not be null");
        }

        Booking booking = bookings.stream()
                .filter(b -> bookingId.equals(b.getBookingId()))
                .findAny()
                .orElseThrow(() -> new BookingNotFoundException(bookingId));

        if ("Cancelled".equalsIgnoreCase(booking.getStatus())) {
            throw new BookingOperationException("Booking " + bookingId + " is already cancelled.");
        }

        booking.setStatus("Cancelled");
        return booking;
    }

    @Override
    public Booking getBookingDetails(Long bookingId) {
        if (bookingId == null) {
            throw new IllegalArgumentException("bookingId must not be null");
        }

        return bookings.stream()
                .filter(b -> bookingId.equals(b.getBookingId()))
                .findAny()
                .orElseThrow(() -> new BookingNotFoundException(bookingId));
    }

    @Override
    public Booking bookSlot(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("booking must not be null");
        }

        boolean exists = bookings.stream()
                .anyMatch(b -> b.getBookingId() != null && b.getBookingId().equals(booking.getBookingId()));
        if (exists) {
            throw new BookingOperationException("Booking with id " + booking.getBookingId() + " already exists.");
        }

        bookings.add(booking);
        return booking;
    }
}