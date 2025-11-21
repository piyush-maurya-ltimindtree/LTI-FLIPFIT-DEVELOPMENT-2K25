package com.flipfit.controller;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.dto.GymSlotRequest;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.GymSlotStatus;
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

    @PostMapping
    public ResponseEntity<GymCenterResponse> createGymCenter(@RequestBody GymCenterRequest request) {
        return ResponseEntity.ok(gymCenterService.createGymCenter(request));
    }

    @PutMapping("/{centerId}/request-approval")
    public ResponseEntity<Boolean> requestApproval(@PathVariable Long centerId) {
        return ResponseEntity.ok(gymCenterService.requestApproval(centerId));
    }

    @GetMapping
    public ResponseEntity<List<GymCenterResponse>> getCentersByCity(@RequestParam String city) {
        return ResponseEntity.ok(gymCenterService.getGymCentersByCity(city));
    }

}
