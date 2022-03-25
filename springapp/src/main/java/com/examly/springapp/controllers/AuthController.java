package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.models.AdminModel;
import com.examly.springapp.models.UserModel;
import com.examly.springapp.services.AdminService;
import com.examly.springapp.services.UserService;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://8081-ececfbcfdafeeaceeaebabaadabeeadfecdaaaa.examlyiopb.examly.io")
public class AuthController {

	@Autowired 
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/user/signup")
	public String saveUser(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			UserModel userObj= userService.fetchUserByEmail(tempEmail);
			AdminModel adminObj = adminService.fetchUserByEmail(tempEmail);
			if(userObj != null || adminObj != null) {
				throw new Exception("Email already exist");
			}
		}
		user.setUserRole("user");
		userService.saveUser(user);
		return ("signed up sucessfully");
	}
	
	@PostMapping("/admin/signup")
	public String saveAdmin(@RequestBody AdminModel admin) throws Exception {
		String tempEmail = admin.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			AdminModel adminObj = adminService.fetchUserByEmail(tempEmail);
			UserModel userObj= userService.fetchUserByEmail(tempEmail);
			if(adminObj != null || userObj != null) {
				throw new Exception("Email already exist");
			}
		}
		admin.setUserRole("admin");
		adminService.saveAdmin(admin);
		return ("admin signedup");
	}
	
	@PostMapping("/user/login")
	public String isUserPresent(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
		if(tempEmail != null && !"".equals(tempEmail)) {
			UserModel userObj= userService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
			AdminModel adminObj = adminService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
			if(userObj == null & adminObj == null) {
				throw new Exception("cant find the user");
			}
			if(userObj != null) {
				return "user";
			}
			if(adminObj != null) {
				return "admin";
			}
		}
		return "";
	}
	
//	@PostMapping("/admin/login")
//	public boolean isAdminPresent(@RequestBody String email, String password) throws Exception {
//		String tempEmail = email;
//		String tempPassword = password;
//		
//		if(tempEmail != null && !"".equals(tempEmail)) {
//			AdminModel userObj= adminService.fetchUserByEmailAndPassword(tempEmail, tempPassword);
//			if(userObj == null) {
//				throw new Exception("cant find the user");
//			}
//		}
//		return true;
//	}
}
