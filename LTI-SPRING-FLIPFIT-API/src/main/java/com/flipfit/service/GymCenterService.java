package com.flipfit.service;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.dto.GymSlotRequest;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.GymSlotStatus;

import java.util.List;

public interface GymCenterService {

    GymCenterResponse createGymCenter(GymCenterRequest request);
    Boolean requestApproval(Long gymCenterId);
    List<GymCenterResponse> getGymCentersByCity(String city);

}
