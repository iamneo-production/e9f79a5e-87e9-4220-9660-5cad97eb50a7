package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.models.UserModel;
import com.examly.springapp.services.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/admin/addUser")
	public String addUser(@RequestBody UserModel user) throws Exception {
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail)) {
			UserModel userObj = userService.fetchUserByEmail(tempEmail);
			if(userObj != null) {
				throw new Exception("Email already exist");
			}
		}
		UserModel userObj = user;
		userService.saveUser(userObj);
		return ("created sucessfully");
	}
	
	@GetMapping("/admin/getUser/{id}")
	public UserModel getUser(@PathVariable int id) throws Exception {
		UserModel userObj = userService.findUserById(id);
		if(userObj == null) {
			throw new Exception("id not found");
		}
		return userObj;
	}
	
	@PutMapping("/admin/editUser/{id}")
	public String editUser(@PathVariable int id, @RequestBody UserModel user) throws Exception {
		UserModel userObj = userService.findUserById(id);
		if(userObj == null) {
			throw new Exception("id not exist");
		}
		userObj.setName(user.getName());
		userObj.setEmail(user.getEmail());
		userObj.setPassword(user.getPassword());
		userObj.setMobileNumber(user.getMobileNumber());
		userObj.setUserRole(user.getUserRole());
		userService.saveUser(userObj);
		return ("updated sucessfully");
	}
	
	@DeleteMapping("/admin/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) throws Exception {
		UserModel userObj = userService.findUserById(id);
		if(userObj == null) {
			throw new Exception("id not exist");
		}
		userService.deleteUser(id);
		return ("deleted sucessfully");
	}
}
