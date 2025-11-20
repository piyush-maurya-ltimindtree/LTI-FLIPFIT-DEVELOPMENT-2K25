package com.flipfit.controller;

import java.util.List;

import com.flipfit.entity.GymCenter;
import com.flipfit.entity.GymSlot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
