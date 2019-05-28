package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedelivery.model.Notification;
import com.example.onlinedelivery.repositories.NotificationRepository;

@Service
@Transactional
public class NotificationServiceImpl implements GenericService<Notification> {

	@Autowired
	private NotificationRepository notificationRepo;

	@Override
	public Notification saveInfo(Notification t) {
		return notificationRepo.save(t);
	}

	@Override
	public Notification updateInfo(Notification t) {
		return notificationRepo.save(t);
	}

	@Override
	public boolean deleteById(int id) {
		notificationRepo.deleteById(id);
		return true;
	}

	@Override
	public List<Notification> getallInfo() {
		return notificationRepo.findAll();
	}

	@Override
	public Optional<Notification> getInfoById(int id) {
		return notificationRepo.findById(id);
	}

}
