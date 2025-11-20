package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.beans.Booking;
import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymSlot;

@RestController
@RequestMapping("/api/gymowner")
public class GymOwnerController {
	
	@PostMapping("/gymcenter")
	public GymCenter addGymCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/gymcenter")
	public GymCenter updateGymCenterDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/bookings")
	public List<Booking> viewBookingsForGymCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("/gymslot")
	public void configureGymSlots() {
		// TODO Auto-generated method stub
		
	}

	@GetMapping("/gymcenter")
	public GymCenter getGymCenterByGymOwnerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/gymslots")
	public List<GymSlot> getGymSlotsByGymCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping("/gymowner")
	public Boolean requestGymOwnerApproval() {
		// TODO Auto-generated method stub
		return null;
	}

}
