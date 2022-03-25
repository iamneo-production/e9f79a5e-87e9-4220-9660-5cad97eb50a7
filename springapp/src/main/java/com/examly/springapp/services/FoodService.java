package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.MenuModel;
import com.examly.springapp.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepo;
	
	public MenuModel saveMenu(MenuModel menu) {
		return foodRepo.save(menu);
	}

	public MenuModel fetchByItem(String itemName) {
		return foodRepo.findByFoodMenuItems(itemName);
	}

	public MenuModel fetchById(int id) {
		return foodRepo.findByFoodMenuID(id);
		
	}

	public void deleteMenu(int id) {
		foodRepo.deleteById(id);
		
	}
}
