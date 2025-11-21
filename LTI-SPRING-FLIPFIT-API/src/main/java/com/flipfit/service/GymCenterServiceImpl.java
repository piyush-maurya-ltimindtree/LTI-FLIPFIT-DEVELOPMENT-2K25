//package com.flipfit.service;
//
//import com.flipfit.dto.GymCenterRequest;
//import com.flipfit.dto.GymCenterResponse;
//import com.flipfit.entity.GymCenter;
//import com.flipfit.repository.GymCenterRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * Class: GymCenterServiceImpl
// * Author: Ankam Bhavana
// * Created on: 21-11-2025
// */
//@Service
//@RequiredArgsConstructor
//public class GymCenterServiceImpl implements GymCenterService {
//
//    private final GymCenterRepository gymCenterRepository;
//
//    /**
//     * Method: createGymCenter
//     * Author: Ankam Bhavana
//     * Created on: 21-11-2025
//     */
//    @Override
//    public GymCenterResponse createGymCenter(GymCenterRequest request) {
//        GymCenter center = GymCenter.builder().gymCenterId(request.getGymCenterId()).gymOwnerId(request.getGymOwnerId()).gymCenterName(request.getGymCenterName()).gstNumber(request.getGstNumber()).address(request.getAddress()).capacity(request.getCapacity()).isApproved(false).amountPerSlot(request.getAmountPerSlot()).build();
//
//        GymCenter savedCenter = gymCenterRepository.save(center);
//
//        return new GymCenterResponse(savedCenter.getId(), savedCenter.getGymCenterName(), savedCenter.getAddress().getCity(), savedCenter.getCapacity(), savedCenter.getIsApproved());
//    }
//
//    /**
//     * Method: requestApproval
//     * Author: Ankam Bhavana
//     * Created on: 21-11-2025
//     */
//    @Override
//    public Boolean requestApproval(Long gymCenterId) {
//        GymCenter center = gymCenterRepository.findById(gymCenterId).orElseThrow(() -> new RuntimeException("GymCenter not found with ID: " + gymCenterId));
//
//        center.setIsApproved(true);
//        gymCenterRepository.save(center);
//        return true;
//    }
//
//    /**
//     * Method: getGymCentersByCity
//     * Author: Ankam Bhavana
//     * Created on: 21-11-2025
//     */
//    @Override
//    public List<GymCenterResponse> getGymCentersByCity(String city) {
//        return gymCenterRepository.findAll().stream().filter(center -> center.getAddress().getCity().equalsIgnoreCase(city)).map(center -> new GymCenterResponse(center.getId(), center.getGymCenterName(), center.getAddress().getCity(), center.getCapacity(), center.getIsApproved())).collect(Collectors.toList());
//    }
//}

package com.flipfit.service;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import com.flipfit.entity.GymCenter;
import com.flipfit.repository.GymCenterRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class: GymCenterServiceImpl
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
@Service
@RequiredArgsConstructor
public class GymCenterServiceImpl implements GymCenterService {

    private static final Logger logger = LoggerFactory.getLogger(GymCenterServiceImpl.class);

    private final GymCenterRepository gymCenterRepository;

    /**
     * Method: createGymCenter
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @Override
    public GymCenterResponse createGymCenter(GymCenterRequest request) {
        logger.debug("Creating GymCenter with request: {}", request);
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
        logger.info("GymCenter saved successfully with ID: {}", savedCenter.getId());

        return new GymCenterResponse(savedCenter.getId(), savedCenter.getGymCenterName(),
                savedCenter.getAddress().getCity(), savedCenter.getCapacity(), savedCenter.getIsApproved());
    }

    /**
     * Method: requestApproval
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @Override
    public Boolean requestApproval(Long gymCenterId) {
        logger.debug("Requesting approval for GymCenter ID: {}", gymCenterId);
        GymCenter center = gymCenterRepository.findById(gymCenterId)
                .orElseThrow(() -> {
                    logger.error("GymCenter not found with ID: {}", gymCenterId);
                    return new RuntimeException("GymCenter not found with ID: " + gymCenterId);
                });

        center.setIsApproved(true);
        gymCenterRepository.save(center);
        logger.info("GymCenter ID {} approved successfully", gymCenterId);
        return true;
    }

    /**
     * Method: getGymCentersByCity
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    @Override
    public List<GymCenterResponse> getGymCentersByCity(String city) {
        logger.debug("Fetching GymCenters for city: {}", city);
        List<GymCenterResponse> centers = gymCenterRepository.findAll().stream()
                .filter(center -> center.getAddress().getCity().equalsIgnoreCase(city))
                .map(center -> new GymCenterResponse(center.getId(), center.getGymCenterName(),
                        center.getAddress().getCity(), center.getCapacity(), center.getIsApproved()))
                .collect(Collectors.toList());
        logger.info("Found {} GymCenters for city {}", centers.size(), city);
        return centers;
    }
}