package com.flipfit.service;

import java.util.ArrayList;
import java.util.List;

import com.flipfit.entity.Booking;
import org.springframework.stereotype.Service;


/**
 * @author Mayuresh Arvind Gujar
 */
@Service
public class GymCustomerServiceImpl implements GymCustomerService {
    private final List<Booking> bookings = new ArrayList<>();

    public GymCustomerServiceImpl() {

    }

    @Override
    public List<Booking> viewBookings() {
        return bookings;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        return null;
    }

    @Override
    public Booking getBookingDetails(Long bookingId) {
        return null;
    }

    @Override
    public Booking bookSlot(Booking booking) {
        return null;
    }
}