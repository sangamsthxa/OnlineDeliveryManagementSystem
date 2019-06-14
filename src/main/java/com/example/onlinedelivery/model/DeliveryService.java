package com.example.onlinedelivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
	 
//	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.LAZY)
//	@JoinColumn(name = "vendor_id")
//	private Vendor vendor;
	
	@ToString.Exclude
//	private Client client;
	@OneToMany( mappedBy="service",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinColumn(name="vehicle_id")
	private List<VehicleType> vehicleType;
	

	

}
