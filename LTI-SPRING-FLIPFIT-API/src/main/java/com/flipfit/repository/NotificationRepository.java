package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flipfit.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
}
