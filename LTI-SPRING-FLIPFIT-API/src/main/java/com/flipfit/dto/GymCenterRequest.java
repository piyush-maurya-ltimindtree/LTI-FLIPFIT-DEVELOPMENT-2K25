package com.flipfit.dto;

import com.flipfit.entity.GymAddress;
import lombok.Data;
/**
 * Class: GymCenterRequest
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
@Data
public class GymCenterRequest {
    private Long gymCenterId;
    private Long gymOwnerId;
    private String gymCenterName;
    private String gstNumber;
    private GymAddress address;
    private Integer capacity;
    private Double amountPerSlot;
}