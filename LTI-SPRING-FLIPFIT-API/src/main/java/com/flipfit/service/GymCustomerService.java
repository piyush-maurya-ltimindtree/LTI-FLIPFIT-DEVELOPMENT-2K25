package com.flipfit.service;

import java.util.List;

import com.flipfit.entity.Booking;
import org.springframework.stereotype.Component;

/**
 * @author Mayuresh Arvind Gujar
 */
@Component
public interface GymCustomerService {
	
	public List<Booking> viewBookings();
	
	public Booking cancelBooking(Long bookingId);
	
	public Booking getBookingDetails(Long bookingId);
	
	public Booking bookSlot(Booking booking);

}
