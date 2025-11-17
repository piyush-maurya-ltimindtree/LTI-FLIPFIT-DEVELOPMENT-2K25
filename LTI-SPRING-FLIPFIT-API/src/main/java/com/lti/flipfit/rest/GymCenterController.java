package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.beans.GymCenter;
import com.lti.flipfit.beans.GymSlot;

@RestController
@RequestMapping("/api/gymcenter")
public class GymCenterController {
	
	
	public List<GymSlot> getSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean getAvailability() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public GymCenter getGymCenterByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Boolean requestGymCenterApproval(Long gymCenterId) {
		// TODO Auto-generated method stub
		return null;
	}

}
