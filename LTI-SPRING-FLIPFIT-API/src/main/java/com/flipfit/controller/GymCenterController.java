package com.flipfit.controller;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.service.GymCenterService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class: GymCenterController
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
@RestController
@RequestMapping("/api/gymcenters")
@RequiredArgsConstructor
public class GymCenterController {
    private static final Logger logger = LoggerFactory.getLogger(GymCenterController.class);

    private final GymCenterService gymCenterService;

    /**
     * Method: createGymCenter
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @PostMapping
    public ResponseEntity<GymCenterResponse> createGymCenter(@RequestBody GymCenterRequest request) {
        return ResponseEntity.ok(gymCenterService.createGymCenter(request));
    }

    /**
     * Method: requestApproval
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @PutMapping("/{centerId}/request-approval")
    public ResponseEntity<Boolean> requestApproval(@PathVariable Long centerId) {
        //return ResponseEntity.ok(gymCenterService.requestApproval(centerId));

        logger.info("Requesting approval for GymCenter ID: {}", centerId);
        Boolean result = gymCenterService.requestApproval(centerId);
        logger.info("Approval status updated for GymCenter ID {}: {}", centerId, result);
        return ResponseEntity.ok(result);
    }

    /**
     * Method: getCentersByCity
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @GetMapping
    public ResponseEntity<List<GymCenterResponse>> getCentersByCity(@RequestParam String city) {
        //return ResponseEntity.ok(gymCenterService.getGymCentersByCity(city));
        logger.info("Fetching GymCenters for city: {}", city);
        List<GymCenterResponse> centers = gymCenterService.getGymCentersByCity(city);
        logger.info("Found {} GymCenters for city {}", centers.size(), city);
        return ResponseEntity.ok(centers);
    }

}
