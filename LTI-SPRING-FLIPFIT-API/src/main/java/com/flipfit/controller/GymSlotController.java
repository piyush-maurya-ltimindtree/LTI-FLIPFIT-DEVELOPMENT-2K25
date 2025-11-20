package com.lti.flipfit.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.flipfit.beans.GymSlot;

@RestController
@RequestMapping("/api/gymslot")
public class GymSlotController {

	
	public List<GymSlot> getSlots() {
		// TODO Auto-generated method stub
		return null;
	}

}
