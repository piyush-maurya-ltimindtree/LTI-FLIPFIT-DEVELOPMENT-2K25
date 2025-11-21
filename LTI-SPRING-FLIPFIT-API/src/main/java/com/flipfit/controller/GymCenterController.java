package com.flipfit.controller;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.dto.GymSlotResponse;
import com.flipfit.service.GymCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gymcenters")
@RequiredArgsConstructor
public class GymCenterController {

    private final GymCenterService gymCenterService;

    @GetMapping("/{centerId}/slots")
    public ResponseEntity<List<GymSlotResponse>> getSlots(@PathVariable Long centerId) {
        return ResponseEntity.ok(gymCenterService.getSlots(centerId));
    }

    @GetMapping("/{centerId}/availability")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable Long centerId,
                                                     @RequestParam String date,
                                                     @RequestParam String startTime) {
        return ResponseEntity.ok(gymCenterService.checkAvailability(centerId, date, startTime));
    }

    @GetMapping("/city")
    public ResponseEntity<List<GymCenterResponse>> getCentersByCity(@RequestParam String city) {
        return ResponseEntity.ok(gymCenterService.getGymCentersByCity(city));
    }

    @PutMapping("/{centerId}/request-approval")
    public ResponseEntity<Boolean> requestApproval(@PathVariable Long centerId) {
        return ResponseEntity.ok(gymCenterService.requestApproval(centerId));
    }

    @PostMapping
    public ResponseEntity<GymCenterResponse> createGymCenter(@RequestBody GymCenterRequest request) {
        return ResponseEntity.ok(gymCenterService.createGymCenter(request));
    }
}
