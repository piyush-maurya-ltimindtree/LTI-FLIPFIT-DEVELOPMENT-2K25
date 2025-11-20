package com.flipfit.service;

import com.flipfit.dto.LoginRequest;
import com.flipfit.dto.RegisterRequest;

/**
 * User service for authentication and registration.
 *
 * @author Mayuresh Arvind Gujar
 */
public interface GymUserService {

    /**
     * Validates credentials and authenticates a user.
     *
     * @param req login request payload
     * @return true if authentication succeeds
     */
    Boolean login(LoginRequest req);

    /**
     * Registers a new user account.
     *
     * @param req registration request payload
     */
    void register(RegisterRequest req);
}