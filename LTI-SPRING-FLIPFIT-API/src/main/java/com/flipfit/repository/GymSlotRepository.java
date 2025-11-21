package com.flipfit.repository;


import com.flipfit.entity.GymSlot;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface GymSlotRepository extends JpaRepository<GymSlot, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM GymSlot s WHERE s.id = :id")
    Optional<GymSlot> findByIdForUpdate(@Param("id") Long id);

    // lookup by center/date/startTime for availability
    Optional<GymSlot> findByCenterIdAndDateAndStartTime(Long centerId, LocalDate date, LocalTime startTime);
}
