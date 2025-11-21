package com.flipfit.repository;

import com.flipfit.entity.GymCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GymCenterRepository extends JpaRepository<GymCenter, Long> {
    Optional<GymCenter> findByGymCenterId(Long gymCenterId);
    List<GymCenter> findByGymOwnerId(Long gymOwnerId);
    List<GymCenter> findByIsApproved(Boolean isApproved);
    Optional<GymCenter> findByGstNumber(String gstNumber);

    @Query("""
        SELECT g FROM GymCenter g
        WHERE LOWER(g.gymCenterName) LIKE LOWER(CONCAT('%', :name, '%'))
        """)
    List<GymCenter> searchByName(@Param("name") String name);
}
