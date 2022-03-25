package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.UserModel;
import com.examly.springapp.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
		this.passwordEncoder = new BCryptPasswordEncoder(12);
	}
	
	public UserModel saveUser(UserModel user) {
		String encodedPassword=this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return repo.save(user);
	}
	
	public UserModel fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public boolean isPasswordMatch(String password, UserModel userObj) {
		return passwordEncoder.matches(password, userObj.getPassword());
	}
	
	public UserModel fetchUserByEmailAndPassword(String email, String password) {
		UserModel userObj = fetchUserByEmail(email);
		if(userObj != null) {
			boolean isMatch= isPasswordMatch(password,userObj);
			if(isMatch) {
				return userObj;
			}
		}
		return null;
	}

	public UserModel findUserById(int id) {
		return repo.findById(id);
	}
	
	public void deleteUser(int id) {
		repo.deleteById(id);
	}
	
}
 