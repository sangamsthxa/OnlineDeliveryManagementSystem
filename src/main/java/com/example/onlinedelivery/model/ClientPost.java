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
@Table(name= "client_post")
@Data
@EqualsAndHashCode(callSuper = false)
public class ClientPost  extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="sourceLocation", nullable=false)
	private String source;
	
	@Column(name="destinationLocation", nullable=false)
	@Lob
	private String destination;
	
	@Column(name="short_distance" ,nullable= false)
	private String distances;
	
	@Column(name="status")
	private boolean enable;
	
	


}
