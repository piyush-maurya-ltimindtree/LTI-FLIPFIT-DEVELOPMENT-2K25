package com.flipfit.dto;

import com.flipfit.entity.GymSlotStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class CreateGymSlotRequest {
    private Long centerId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer capacity;
    private Integer seatsRemaining;
    private GymSlotStatus status;
}
