package com.lti.flipfit.exception;
/**
 * @author Mayuresh Arvind Gujar
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("User not found: " + username);
    }
}