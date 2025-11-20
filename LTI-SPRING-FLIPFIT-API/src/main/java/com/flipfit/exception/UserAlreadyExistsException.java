package com.flipfit.exception;
/**
 * @author Mayuresh Arvind Gujar
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username) {
        super("User already exists: " + username);
    }
}