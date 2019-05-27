package com.example.onlinedelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="notification")
@Data
@EqualsAndHashCode(callSuper = false)
public class Notification extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="notification_name",nullable=false)
	private String notificationName;
	
	@Column(name="notification_type", nullable=false)
	private String notificationType;
	
//	private DeliveryService service;
	
//	private Vendor vendor;
	
//	private Client client;
	

}
