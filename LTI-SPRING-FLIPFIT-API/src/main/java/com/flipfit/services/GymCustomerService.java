package com.lti.flipfit.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.beans.GymSlot;
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
