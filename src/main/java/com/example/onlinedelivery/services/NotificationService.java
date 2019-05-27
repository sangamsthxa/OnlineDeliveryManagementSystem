package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import com.example.onlinedelivery.model.Notification;

public interface NotificationService {
	
	public Notification saveNotification(Notification notification);
	
	public Notification updateNotification(Notification notification);
	
	public boolean deleteNotification(int id);
	
	public List<Notification> getAllNotificationInfo();
	
	public Optional<Notification> getAllNotificationById(int id);
	
	
	
	
	
	
	

}
