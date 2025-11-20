package com.flipfit.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class SlotNotFoundException extends RuntimeException{

    public SlotNotFoundException(String message) {
        super(message);
    }
}
