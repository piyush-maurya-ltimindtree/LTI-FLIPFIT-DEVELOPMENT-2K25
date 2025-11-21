package com.flipfit.service;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.entity.GymCenter;
import com.flipfit.repository.GymCenterRepository;
import com.flipfit.repository.GymSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GymCenterServiceImpl implements GymCenterService {

    private final GymCenterRepository gymCenterRepository;

    @Override
    public GymCenterResponse createGymCenter(GymCenterRequest request) {
        GymCenter center = GymCenter.builder()
                .gymCenterId(request.getGymCenterId())
                .gymOwnerId(request.getGymOwnerId())
                .gymCenterName(request.getGymCenterName())
                .gstNumber(request.getGstNumber())
                .address(request.getAddress())
                .capacity(request.getCapacity())
                .isApproved(false)
                .amountPerSlot(request.getAmountPerSlot())
                .build();

        GymCenter savedCenter = gymCenterRepository.save(center);

        return new GymCenterResponse(savedCenter.getId(), savedCenter.getGymCenterName(),
                savedCenter.getAddress().getCity(), savedCenter.getCapacity(), savedCenter.getIsApproved());
    }

    @Override
    public Boolean requestApproval(Long gymCenterId) {
        GymCenter center = gymCenterRepository.findById(gymCenterId)
                .orElseThrow(() -> new RuntimeException("GymCenter not found with ID: " + gymCenterId));

        center.setIsApproved(true);
        gymCenterRepository.save(center);
        return true;
    }

    @Override
    public List<GymCenterResponse> getGymCentersByCity(String city) {
        return gymCenterRepository.findAll().stream()
                .filter(center -> center.getAddress().getCity().equalsIgnoreCase(city))
                .map(center -> new GymCenterResponse(center.getId(), center.getGymCenterName(),
                        center.getAddress().getCity(), center.getCapacity(), center.getIsApproved()))
                .collect(Collectors.toList());
    }


}
