package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.AdminModel;

public interface AdminRepository extends JpaRepository <AdminModel, Integer>{

	public AdminModel findByEmail(String email);
	
	public AdminModel findByEmailAndPassword(String email, String password);
}
