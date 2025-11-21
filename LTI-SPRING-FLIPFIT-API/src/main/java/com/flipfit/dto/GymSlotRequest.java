package com.flipfit.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
public class GymSlotRequest {

    private Long centerId;
    private LocalDate date;
    private LocalTime time;

}
