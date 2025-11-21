package com.flipfit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Class: GymCenterResponse
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
@Data
@AllArgsConstructor
public class GymCenterResponse {
    private Long id;
    private String name;
    private String city;
    private Integer capacity;
    private Boolean isApproved;
}