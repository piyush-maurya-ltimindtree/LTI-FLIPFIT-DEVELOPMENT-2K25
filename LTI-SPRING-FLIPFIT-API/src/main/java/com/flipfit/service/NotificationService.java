package com.flipfit.service;

import com.flipfit.entity.Notification;

import java.util.List;

public interface NotificationService {
	
   public Notification sendNotification(Notification notification);
   
   public List<Notification> getAllNotifications();
   
   public Notification getNotificationById(Long notificationId);
   
   public Notification deleteNotification(Long notificationId);
}