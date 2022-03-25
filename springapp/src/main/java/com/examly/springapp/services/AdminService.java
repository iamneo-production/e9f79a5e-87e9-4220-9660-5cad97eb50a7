package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.AdminModel;
import com.examly.springapp.repository.AdminRepository;

@Service 
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	PasswordEncoder passwordEncoder;
	
	public AdminService(AdminRepository adminRepo) {
		this.adminRepo = adminRepo;
		this.passwordEncoder = new BCryptPasswordEncoder(12);
	}
	
	public boolean isPasswordMatch(String password, AdminModel adminObj) {
		return passwordEncoder.matches(password, adminObj.getPassword());
	}
	
	public AdminModel saveAdmin(AdminModel admin) {
		String encodedPassword=this.passwordEncoder.encode(admin.getPassword());
		admin.setPassword(encodedPassword);
		return adminRepo.save(admin);
	}
	
	public AdminModel fetchUserByEmail(String email) {
		return adminRepo.findByEmail(email);
	}
	
	public AdminModel fetchUserByEmailAndPassword(String email, String password) {
		AdminModel adminObj = fetchUserByEmail(email);
		if(adminObj != null) {
			boolean isMatch= isPasswordMatch(password,adminObj);
			if(isMatch) {
				return adminObj;
			}
		}
		
		return null;
	}

}
