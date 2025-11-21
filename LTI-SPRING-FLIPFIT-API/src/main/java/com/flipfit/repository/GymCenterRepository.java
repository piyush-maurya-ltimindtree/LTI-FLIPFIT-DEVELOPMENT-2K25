package com.flipfit.repository;

import com.flipfit.entity.GymCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Class: GymCenterRepository
 * Author: Ankam Bhavana
 * Created on: 21-11-2025
 */
public interface GymCenterRepository extends JpaRepository<GymCenter, Long> {
    /**
     * Method: findByGymCenterId
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    Optional<GymCenter> findByGymCenterId(Long gymCenterId);

    /**
     * Method: findByGymOwnerId
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    List<GymCenter> findByGymOwnerId(Long gymOwnerId);

    /**
     * Method: findByIsApproved
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    List<GymCenter> findByIsApproved(Boolean isApproved);

    /**
     * Method: findByGstNumber
     * Author: Ankam Bhavana
     * Created on: 21-11-2025
     */
    Optional<GymCenter> findByGstNumber(String gstNumber);

    @Query("""
            SELECT g FROM GymCenter g
            WHERE LOWER(g.gymCenterName) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    List<GymCenter> searchByName(@Param("name") String name);
}
