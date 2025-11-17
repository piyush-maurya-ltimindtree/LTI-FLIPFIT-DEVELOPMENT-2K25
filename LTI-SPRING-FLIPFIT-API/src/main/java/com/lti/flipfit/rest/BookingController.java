package com.lti.flipfit.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.services.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	
	
	public BookingService createBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BookingService cancelBooking() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean checkBookingOverlap() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String makePayment() {
		// TODO Auto-generated method stub
		return null;
	}


}
