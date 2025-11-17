package com.lti.flipfit.services;

public interface BookingService {
	
	public BookingService createBooking();
	public BookingService cancelBooking();
	public Boolean checkBookingOverlap();
	public String makePayment();
	

}
