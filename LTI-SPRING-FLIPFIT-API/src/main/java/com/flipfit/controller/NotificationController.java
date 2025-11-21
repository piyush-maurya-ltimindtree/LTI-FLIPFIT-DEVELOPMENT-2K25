
package com.flipfit.controller;

import com.flipfit.entity.Notification;
import com.flipfit.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
/*
     *@Method-
     *@Description-
     *@MethodParameters-
     *@exception-
*/

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
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Notification> sendNotification(@RequestBody Notification notification) {
        Notification created = notificationService.sendNotification(notification);
        return ResponseEntity
                .created(URI.create("/api/notification/" + created.getNotificationId()))
                .body(created);
    }

  

    /**
     * Delete a notification by id
     * DELETE /api/notification/{id}
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Notification> deleteNotification(@PathVariable("id") Long id) {
        Notification deleted = notificationService.deleteNotification(id);
        return ResponseEntity.ok(deleted);
    }
}
