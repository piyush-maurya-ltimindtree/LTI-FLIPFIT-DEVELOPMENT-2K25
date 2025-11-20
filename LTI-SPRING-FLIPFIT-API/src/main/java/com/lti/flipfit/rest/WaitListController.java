
package com.lti.flipfit.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.flipfit.beans.GymUser;
import com.lti.flipfit.services.WaitListService;

@RestController
@RequestMapping("/api/waitlist")
public class WaitListController {

    private final WaitListService waitListService;

    public WaitListController(WaitListService waitListService) {
        this.waitListService = waitListService;
    }

    
    @PostMapping("/promote")
    public ResponseEntity<GymUser> promoteUser(@RequestBody GymUser gymUser) {
        // delegate to the single service
        GymUser promoted = waitListService.promoteUser(gymUser);
        return ResponseEntity.ok(promoted);
    }

    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("WaitList service is up");
    }
}
