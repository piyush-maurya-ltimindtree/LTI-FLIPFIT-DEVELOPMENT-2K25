package com.flipfit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GymCenterResponse {
    private Long id;
    private String name;
    private String city;
    private Integer capacity;
    private Boolean isApproved;
}