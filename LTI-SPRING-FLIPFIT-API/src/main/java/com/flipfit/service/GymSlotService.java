package com.flipfit.service;

import com.flipfit.dto.CreateGymSlotRequest;
import com.flipfit.dto.GymSlotRequest;
import com.flipfit.entity.GymSlot;
import com.flipfit.entity.GymSlotStatus;

public interface GymSlotService {

    GymSlot getSlot(Long slotId);
    GymSlot getSlots(GymSlotRequest request);
    GymSlot checkAvailability(GymSlotRequest request);
    GymSlot createSlot(CreateGymSlotRequest request);
    GymSlot updateSlot(GymSlot gymSlot);

}
