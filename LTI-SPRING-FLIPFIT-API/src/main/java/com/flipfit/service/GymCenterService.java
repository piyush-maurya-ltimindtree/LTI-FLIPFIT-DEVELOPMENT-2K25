package com.flipfit.service;

import com.flipfit.dto.GymCenterRequest;
import com.flipfit.dto.GymCenterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Class: GymCenterService
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
public interface GymCenterService {

    /**
     * Method: createGymCenter
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    GymCenterResponse createGymCenter(GymCenterRequest request);

    /**
     * Method: requestApproval
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    Boolean requestApproval(Long gymCenterId);

    /**
     * Method: getGymCentersByCity
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    List<GymCenterResponse> getGymCentersByCity(String city);

}
