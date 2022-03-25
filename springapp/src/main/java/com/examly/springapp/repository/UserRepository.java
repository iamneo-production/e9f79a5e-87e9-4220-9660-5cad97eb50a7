package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

	public UserModel findByEmail(String email);

	public UserModel findByEmailAndPassword(String email, String password);
	
	public UserModel findById(int id);
}
