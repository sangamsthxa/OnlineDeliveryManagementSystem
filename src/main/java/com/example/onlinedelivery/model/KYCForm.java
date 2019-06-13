package com.example.onlinedelivery.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="kyc_form")
@Data
@EqualsAndHashCode(callSuper = false)
public class KYCForm extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="photo", nullable = false)
	private String photo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date dob;
	
	@Column(name="legal_doc",nullable=false)
	private String legalDoc;

}
