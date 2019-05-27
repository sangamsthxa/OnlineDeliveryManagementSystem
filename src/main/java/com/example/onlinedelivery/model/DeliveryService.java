package com.example.onlinedelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="delivery_service")
@Data
@EqualsAndHashCode(callSuper = false)
public class DeliveryService extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="service_initial_location", nullable=false)
	private String serviceInitialLocation;
	
	@Column(name="service_final_location", nullable=false)
	private String serviceFinalLocation;
	
	@Column(name="service_quantity", nullable=false)
	private int serviceQuantity;
	
	@Column(name="description", nullable=false)
	@Lob
	private String description;
	
	@Column(name="service_status",nullable=false)
	private boolean serviceStatus;
	 
//	private Vendor vendor;
//	private Client client;
//	private VehicleType vehicleType;
	

	

}
