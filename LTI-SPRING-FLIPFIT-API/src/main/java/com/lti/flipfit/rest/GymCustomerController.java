package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.beans.GymSlot;

@RestController
@RequestMapping("/api/gymcustomer")
public class GymCustomerController {
	
	@GetMapping("/bookings")
	public List<Booking> viewBookings(){
		return null;
		
	}
	
	@PostMapping("/cancel/{bookingId}")
	public Booking cancelBooking(@PathVariable Long bookingId) {
		return null;
		
	}
	
	@GetMapping("/booking/{bookingId}")
	public Booking getBookingDetails(@PathVariable Long bookingId) {
		return null;
		
	}
	
	@GetMapping("/gymSlots")
	public GymSlot bookSlot() {
		return null;
		
	}

}
