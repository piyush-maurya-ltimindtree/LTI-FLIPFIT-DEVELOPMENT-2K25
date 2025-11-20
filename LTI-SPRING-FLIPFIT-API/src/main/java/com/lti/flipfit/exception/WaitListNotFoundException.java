
package com.lti.flipfit.exception;

public class WaitListNotFoundException extends RuntimeException {

    public WaitListNotFoundException(Long waitListId) {
        super("No waitlist entry found for id: " + waitListId);
    }

    public WaitListNotFoundException(String message) {
        super(message);
    }
}
