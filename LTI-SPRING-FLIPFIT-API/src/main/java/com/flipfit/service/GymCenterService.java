package com.flipfit.service;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.dto.GymSlotResponse;

import java.util.List;

public interface GymCenterService {
    List<GymSlotResponse> getSlots(Long centerId);
    Boolean checkAvailability(Long centerId, String date, String startTime);
    List<GymCenterResponse> getGymCentersByCity(String city);
    Boolean requestApproval(Long gymCenterId);
    GymCenterResponse createGymCenter(GymCenterRequest request);
}
