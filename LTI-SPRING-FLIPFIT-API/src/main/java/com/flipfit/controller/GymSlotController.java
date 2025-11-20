package com.flipfit.controller;

import java.util.List;

import com.flipfit.entity.GymSlot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/gymslot")
public class GymSlotController {

	
	public List<GymSlot> getSlots() {
		// TODO Auto-generated method stub
		return null;
	}

}
