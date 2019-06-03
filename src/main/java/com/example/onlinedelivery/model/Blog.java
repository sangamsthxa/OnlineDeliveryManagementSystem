package com.example.onlinedelivery.model;

import java.util.Date;

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
@Table(name= "blog")
@Data
@EqualsAndHashCode(callSuper = false)
public class Blog extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="title", nullable=false)
	private String title;
	@Column(name="description", nullable=false)
	@Lob
	private String description;

	
}
