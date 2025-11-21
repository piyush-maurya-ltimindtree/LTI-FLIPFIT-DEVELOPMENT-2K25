
package com.flipfit.service;

import com.flipfit.entity.Notification;

public interface NotificationService {

    Notification sendNotification(Notification notification);

   
    Notification deleteNotification(Long notificationId);
}
