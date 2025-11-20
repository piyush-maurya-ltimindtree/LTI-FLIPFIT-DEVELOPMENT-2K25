package com.flipfit.controller;

import com.flipfit.dto.LoginRequest;
import com.flipfit.dto.RegisterRequest;
import com.flipfit.service.GymUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User endpoints for registration and login.
 *
 * @author Mayuresh Arvind Gujar
 */
@RestController
@RequestMapping("/api/v1/gymuser")
@RequiredArgsConstructor
public class GymUserController {

    private final GymUserService gymUserService;

    /**
     * Registers a new user account using validated payload.
     *
     * @param req registration request (validated)
     * @return 201 Created on success
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest req) {
        gymUserService.register(req);
        return ResponseEntity.status(201).build();
    }

    /**
     * Authenticates user credentials and returns success status.
     *
     * @param req login request (validated)
     * @return 200 OK with boolean indicating authentication success
     */
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@Valid @RequestBody LoginRequest req) {
        return ResponseEntity.ok(gymUserService.login(req));
    }
}