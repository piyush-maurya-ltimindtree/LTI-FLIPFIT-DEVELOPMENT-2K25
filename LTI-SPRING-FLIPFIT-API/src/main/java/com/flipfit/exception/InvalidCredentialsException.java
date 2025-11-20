package com.flipfit.exception;
/**
 * @author Mayuresh Arvind Gujar
 */
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Invalid username or password");
    }
}
