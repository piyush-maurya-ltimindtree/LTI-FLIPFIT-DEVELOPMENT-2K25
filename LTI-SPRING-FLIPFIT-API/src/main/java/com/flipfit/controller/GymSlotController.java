package com.flipfit.controller;

import java.util.List;

import com.flipfit.dto.CreateGymSlotRequest;
import com.flipfit.dto.GymSlotRequest;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.GymSlotStatus;
import com.flipfit.service.GymSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/gymslots")
@RequiredArgsConstructor
public class GymSlotController {

	private final GymSlotService gymSlotService;

	@GetMapping
	public ResponseEntity<GymSlot> getSlots(@RequestBody GymSlotRequest request) {
		return ResponseEntity.ok(gymSlotService.getSlots(request));
	}

	@GetMapping("/availability")
	public ResponseEntity<GymSlot> checkAvailability(@RequestBody GymSlotRequest request) {
		return ResponseEntity.ok(gymSlotService.checkAvailability(request));
	}

	@PostMapping
	public ResponseEntity<GymSlot> createSlot(@RequestBody CreateGymSlotRequest request){
		return  ResponseEntity.ok(gymSlotService.createSlot(request));
	}

}
