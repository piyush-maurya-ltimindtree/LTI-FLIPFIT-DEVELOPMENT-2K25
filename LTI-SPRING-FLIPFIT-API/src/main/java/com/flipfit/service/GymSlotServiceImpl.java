package com.flipfit.service;


import com.flipfit.dto.CreateGymSlotRequest;
import com.flipfit.dto.GymSlotRequest;
import com.flipfit.entity.GymSlot;
import com.flipfit.exception.SlotNotFoundException;
import com.flipfit.repository.GymSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GymSlotServiceImpl implements GymSlotService{

    private final GymSlotRepository slotRepo;

    @Override
    public GymSlot getSlot(Long slotId) {

        return slotRepo.findByIdForUpdate(slotId)
                .orElseThrow(() -> new SlotNotFoundException("Slot not found with ID: " + slotId));

    }

    @Override
    public GymSlot getSlots(GymSlotRequest request) {

        return slotRepo.findByCenterIdAndDateAndStartTime(request.getCenterId(),
                        request.getDate(), request.getTime()).stream().findFirst()
                .orElseThrow(()-> new SlotNotFoundException("No slots found"));

    }

    @Override
    public GymSlot checkAvailability(GymSlotRequest request) {

        Optional<GymSlot> slot = slotRepo.findByCenterIdAndDateAndStartTime(request.getCenterId(),
                request.getDate(), request.getTime());


        return slot.orElseThrow(() -> new SlotNotFoundException("Slot Not Found"));


    }

    @Override
    public GymSlot createSlot(CreateGymSlotRequest request) {
        GymSlot gymSlot = GymSlot.builder()
                .centerId(request.getCenterId())
                .date(request.getDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .capacity(request.getCapacity())
                .seatsRemaining(request.getSeatsRemaining())
                .status(request.getStatus())
                .build();

        return slotRepo.save(gymSlot);
    }

    @Override
    public GymSlot updateSlot(GymSlot gymSlot) {
        return slotRepo.save(gymSlot);
    }
}
