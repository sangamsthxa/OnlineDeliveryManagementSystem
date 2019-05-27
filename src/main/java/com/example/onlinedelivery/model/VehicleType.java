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
@Table(name= "vehicle_type")
@Data
@EqualsAndHashCode(callSuper = false)
public class VehicleType extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="type", nullable=false)
	private String vehicleType;
	
	
}

