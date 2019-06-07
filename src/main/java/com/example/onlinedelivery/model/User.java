package com.example.onlinedelivery.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

//    private Long id;
//
//    private String username;
//
//    private String password;
//
//    @javax.persistence.Transient
//    private String passwordConfirm;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	@javax.persistence.Transient
	private String passwordConfirm;

	@Column(name = "first_name", nullable = false)
	@Size(message = "First Name should be atleast 2 characters")
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@Size(message = "last Name should be atleast 2 characters")
	private String lastName;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "email should be valid")
	private String email;

	@Column(name = "address", nullable = false)
	@NotBlank(message = "Address should not be blank")
	private String address;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date dob;

	@Column(name = "mobile_no", unique = true)
	private String contactNo;

	@Column(name = "gender", nullable = false)
	private String gender;

	@ManyToMany
	private Set<Role> roles;

}
