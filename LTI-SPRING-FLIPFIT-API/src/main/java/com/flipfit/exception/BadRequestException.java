package com.flipfit.exception;
/**
 * @author Mayuresh Arvind Gujar
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
