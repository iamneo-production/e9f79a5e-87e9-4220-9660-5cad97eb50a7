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

import com.examly.springapp.models.MenuModel;
import com.examly.springapp.services.FoodService;

@RestController
@RequestMapping
public class FoodMenuController {

	@Autowired
	private FoodService foodService;
	
	@PostMapping("/admin/addMenu")
	public MenuModel addMenu(@RequestBody MenuModel menuDetails) throws Exception {
		String tempItem = menuDetails.getFoodMenuItems();
		if(tempItem != null && !"".equals(tempItem)) {
			MenuModel menuObj = foodService.fetchByItem(tempItem);
			if(menuObj != null) {
				throw new Exception("menu already exist");
			}
		}
		MenuModel menuObj = foodService.saveMenu(menuDetails);
		return menuObj;
	}
	
	@GetMapping("/admin/getMenu/{id}")
	public MenuModel getMenu(@PathVariable int id) throws Exception {
		MenuModel menuObj = foodService.fetchById(id);
		if(menuObj != null) {
			throw new Exception("id not found");
		}
		return menuObj;
	}
	
	@PutMapping("/admin/editMenu/{id}")
	public MenuModel editMenu(@RequestBody MenuModel menuDetails, @PathVariable int id) throws Exception {
		String items = menuDetails.getFoodMenuItems();
		MenuModel menuObj = foodService.fetchById(id);
		if(menuObj == null) {
			throw new Exception("id not found");
		}
		if(foodService.fetchByItem(items) != null) {
			throw new Exception("item already exist");
		}
		menuObj.setFoodMenuCost(menuDetails.getFoodMenuCost());
		menuObj.setFoodMenuItem(menuDetails.getFoodMenuItems());
		menuObj.setFoodMenuType(menuDetails.getFoodMenuType());
		return foodService.saveMenu(menuObj);
	}
	
	
	@DeleteMapping("/admin/deleteMenu/{id}")
	public String deleteMenu(@PathVariable int id) throws Exception {
		MenuModel menuObj = foodService.fetchById(id);
		if(menuObj == null) {
			throw new Exception("id not found");
		}
		foodService.deleteMenu(id);
		return ("sucessfully deleted");
	}
	
	
	
	
	
	
}
