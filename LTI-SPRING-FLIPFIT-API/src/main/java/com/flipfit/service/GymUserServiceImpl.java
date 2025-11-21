package com.flipfit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.flipfit.dto.LoginRequest;
import com.flipfit.dto.RegisterRequest;
import com.flipfit.entity.GymUser;
import com.flipfit.entity.UserRole;
import com.flipfit.entity.UserStatus;
import com.flipfit.exception.BadRequestException;
import com.flipfit.exception.InvalidCredentialsException;
import com.flipfit.exception.UserAlreadyExistsException;
import com.flipfit.exception.UserNotFoundException;
import com.flipfit.repository.GymUserRepository;

import java.util.EnumSet;

/**
 * Implementation of user auth and registration using JPA + MySQL.
 * Contains inline mapping from DTOs to entity to avoid a separate mapper class.
 *
 * @author Mayuresh Arvind Gujar
 */
@Service
@RequiredArgsConstructor
public class GymUserServiceImpl implements GymUserService {

    private final GymUserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Authenticates a user:
     * - Validates payload (non-null, username/password required)
     * - Ensures user exists
     * - Requires status ACTIVE and a valid predefined role
     * - Verifies password using bcrypt
     *
     * @param req incoming credentials (username + password)
     * @return true on successful authentication
     * @throws BadRequestException on invalid input or non-ACTIVE status/role
     * @throws UserNotFoundException when user does not exist
     * @throws InvalidCredentialsException when password mismatch occurs
     */
    @Override
    @Transactional(readOnly = true)
    public Boolean login(LoginRequest req) {
        if (req == null) {
            throw new BadRequestException("login payload must not be null");
        }
        if (req.getUsername() == null || req.getUsername().isBlank()) {
            throw new BadRequestException("username is required");
        }
        if (req.getPassword() == null || req.getPassword().isBlank()) {
            throw new BadRequestException("password is required");
        }

        GymUser stored = repository.findByUserNameIgnoreCase(req.getUsername())
                .orElseThrow(() -> new UserNotFoundException(req.getUsername()));

        if (stored.getStatus() == null || stored.getStatus() != UserStatus.ACTIVE) {
            throw new BadRequestException("user status must be ACTIVE to login");
        }
        if (!isValidRole(stored.getRole())) {
            throw new BadRequestException("invalid or missing role");
        }

        boolean matches = passwordEncoder.matches(req.getPassword(), stored.getUserPassword());
        if (!matches) {
            throw new InvalidCredentialsException();
        }
        return true;
    }

    /**
     * Registers a new user:
     * - Validates payload (non-null, username/password required)
     * - Enforces predefined role values (CUSTOMER, GYMOWNER, ADMIN)
     * - Defaults status to ACTIVE if absent; rejects DELETED
     * - Enforces unique username (case-insensitive)
     * - Stores password as bcrypt hash and persists the user
     *
     * @param req new user data to register
     * @throws BadRequestException on invalid input, role/status violations
     * @throws UserAlreadyExistsException when username is already taken
     */
    @Override
    @Transactional
    public void register(RegisterRequest req) {
        if (req == null) {
            throw new BadRequestException("registration payload must not be null");
        }
        if (req.getUsername() == null || req.getUsername().isBlank()) {
            throw new BadRequestException("username is required");
        }
        if (req.getPassword() == null || req.getPassword().isBlank()) {
            throw new BadRequestException("password is required");
        }

        if (!isValidRole(req.getRole())) {
            throw new BadRequestException("role must be one of: CUSTOMER, GYMOWNER, ADMIN");
        }

        UserStatus status = (req.getStatus() != null ? req.getStatus() : UserStatus.ACTIVE);
        if (status == UserStatus.DELETED) {
            throw new BadRequestException("status cannot be DELETED on registration");
        }
        if (!isValidStatus(status)) {
            throw new BadRequestException("invalid status");
        }

        boolean exists = repository.existsByUserNameIgnoreCase(req.getUsername());
        if (exists) {
            throw new UserAlreadyExistsException(req.getUsername());
        }

        // Map DTO to entity WITHOUT setting the raw password
        GymUser entity = toEntity(req, status);

        // Hash the password and set it on the entity before save
        entity.setUserPassword(passwordEncoder.encode(req.getPassword()));

        repository.save(entity);
    }

    /**
     * Converts RegisterRequest to GymUser entity.
     *
     * Note: This method intentionally does NOT set the raw password.
     * The password is hashed and set in the service before persistence.
     *
     * @param req registration payload
     * @param status resolved status (defaults handled before)
     * @return GymUser entity populated from request
     */
    private GymUser toEntity(RegisterRequest req, UserStatus status) {
        return GymUser.builder()
                .userName(req.getUsername())
                // do not set plaintext password here
                .email(req.getEmail())
                .phone(req.getPhone())
                .role(req.getRole())
                .status(status)
                .build();
    }

    private boolean isValidRole(UserRole role) {
        return role != null && EnumSet.allOf(UserRole.class).contains(role);
    }

    private boolean isValidStatus(UserStatus status) {
        return status != null && EnumSet.allOf(UserStatus.class).contains(status);
    }
}