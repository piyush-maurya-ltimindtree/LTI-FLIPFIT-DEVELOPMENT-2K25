package com.flipfit.dto;


import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private Long centerId;
    private Long slotId;
}
