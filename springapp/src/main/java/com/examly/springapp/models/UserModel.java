package com.examly.springapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence-generator")
	private int id;
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Column(nullable= false, unique=true, length=40)
	private String email;
	
	@Column(nullable= false, length=64)
	private String password;
	
	@Column(nullable=false, length=10)
	private String mobileNumber;
	
	@Column(nullable=false)
	private String userRole;
	
	public UserModel() {
	}

	public UserModel(int id, String name, String email, String password, String mobileNumber, String userRole) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.userRole = userRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}

