package com.flipfit.controller;
 

import com.flipfit.entity.Notification;
import com.flipfit.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.net.URI;
import java.util.List;
 
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
 
    private final NotificationService notificationService;
 
    // Prefer constructor injection
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
 
    /**
     * Create/Send a notification
     * POST /api/notification
     */
    @PostMapping
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        Notification created = notificationService.sendNotification(notification);
        
        return ResponseEntity
                .created(URI.create("/api/notification/" + created.getNotificationId()))
                .body(created);
    }
 
    /**
     * Get all notifications
     * GET /api/notification
     */
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }
 
    /**
     * Get a notification by id
     * GET /api/notification/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable("id") Long id) {
        Notification notification = notificationService.getNotificationById(id);
        return ResponseEntity.ok(notification);
    }
 
    /**
     * Delete a notification by id
     * DELETE /api/notification/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Notification> deleteNotification(@PathVariable("id") Long id) {
        Notification deleted = notificationService.deleteNotification(id);
        return ResponseEntity.ok(deleted);
    }
}