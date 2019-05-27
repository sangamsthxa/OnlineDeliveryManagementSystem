package com.example.onlinedelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinedelivery.model.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
