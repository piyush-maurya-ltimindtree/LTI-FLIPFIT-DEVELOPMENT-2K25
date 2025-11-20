package com.flipfit.controller;

import com.flipfit.entity.GymUser;
import com.flipfit.service.GymUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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