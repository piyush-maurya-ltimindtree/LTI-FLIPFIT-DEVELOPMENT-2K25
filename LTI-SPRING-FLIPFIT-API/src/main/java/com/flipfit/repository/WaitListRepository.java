package com.flipfit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.flipfit.entity.WaitList;

public interface WaitListRepository extends JpaRepository<WaitList, Long> {

    List<WaitList> findBySlotId(Long slotId);

    List<WaitList> findByUserId(Long userId);

    boolean existsBySlotIdAndUserId(Long slotId, Long userId);
}
