package com.lti.flipfit.exception;
/**
 * @author Mayuresh Arvind Gujar
 */
public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long bookingId) {
        super("No booking found for id: " + bookingId);
    }
    public BookingNotFoundException(String message) {
        super(message);
    }
}
