package com.lti.flipfit.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lti.flipfit.beans.GymUser;
import com.lti.flipfit.services.GymUserService;
/**
 * @author Mayuresh Arvind Gujar
 */
@RestController
@RequestMapping("/api/v1/gymuser")
public class GymUserController {

    private final GymUserService gymUserService;

    public GymUserController(GymUserService gymUserService) {
        this.gymUserService = gymUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody GymUser gymUser) {
        gymUserService.register(gymUser);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody GymUser gymUser) {
        return ResponseEntity.ok(gymUserService.login(gymUser));
    }
}