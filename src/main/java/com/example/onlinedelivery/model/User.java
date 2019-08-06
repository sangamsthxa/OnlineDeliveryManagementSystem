package com.example.onlinedelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userName;

	private String password;

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

	@Column(name = "dob")
	private String dob;

	@Column(name = "mobile_no", unique = true)
	private String contactNo;

	@Column(name = "gender", nullable = true)
	private String gender;

	@Column(name = "role_name", nullable = false)
	private String roleName;

	public User() {

	}



	public User(String userName, String password,
			@Size(message = "First Name should be atleast 2 characters") String firstName,
			@Size(message = "last Name should be atleast 2 characters") String lastName,
			@Email(message = "email should be valid") String email,
			@NotBlank(message = "Address should not be blank") String address, String dob, String contactNo,
			String gender, String roleName) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.contactNo = contactNo;
		this.gender = gender;
		this.roleName = roleName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", dob=" + dob
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", roleName=" + roleName + "]";
	}
	
	
	

}
