package com.flipfit.dto;

import com.flipfit.entity.GymAddress;
import lombok.Data;

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