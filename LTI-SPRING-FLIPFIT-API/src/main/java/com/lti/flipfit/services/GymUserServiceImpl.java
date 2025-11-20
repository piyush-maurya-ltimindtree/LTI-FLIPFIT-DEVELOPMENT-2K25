package com.lti.flipfit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lti.flipfit.beans.GymUser;
import com.lti.flipfit.exception.BadRequestException;
import com.lti.flipfit.exception.InvalidCredentialsException;
import com.lti.flipfit.exception.UserAlreadyExistsException;
import com.lti.flipfit.exception.UserNotFoundException;
/**
 * @author Mayuresh Arvind Gujar
 */
@Service
public class GymUserServiceImpl implements GymUserService {

    private final List<GymUser> users = new ArrayList<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Boolean login(GymUser gymUser) {
        if (gymUser == null) {
            throw new BadRequestException("gymUser must not be null");
        }
        if (gymUser.getUserName() == null || gymUser.getUserName().isBlank()) {
            throw new BadRequestException("username is required");
        }
        if (gymUser.getUserPassword() == null || gymUser.getUserPassword().isBlank()) {
            throw new BadRequestException("password is required");
        }

        GymUser stored = users.stream()
                .filter(u -> u.getUserName().equalsIgnoreCase(gymUser.getUserName()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(gymUser.getUserName()));

        boolean matches = passwordEncoder.matches(gymUser.getUserPassword(), stored.getUserPassword());
        if (!matches) {
            throw new InvalidCredentialsException();
        }
        return true;
    }

    @Override
    public void register(GymUser gymUser) {
        if (gymUser == null) {
            throw new BadRequestException("gymUser must not be null");
        }
        if (gymUser.getUserName() == null || gymUser.getUserName().isBlank()) {
            throw new BadRequestException("username is required");
        }
        if (gymUser.getUserPassword() == null || gymUser.getUserPassword().isBlank()) {
            throw new BadRequestException("password is required");
        }

        boolean exists = users.stream()
                .anyMatch(u -> u.getUserName().equalsIgnoreCase(gymUser.getUserName()));
        if (exists) {
            throw new UserAlreadyExistsException(gymUser.getUserName());
        }

        gymUser.setUserPassword(passwordEncoder.encode(gymUser.getUserPassword()));
        users.add(gymUser);
    }
}