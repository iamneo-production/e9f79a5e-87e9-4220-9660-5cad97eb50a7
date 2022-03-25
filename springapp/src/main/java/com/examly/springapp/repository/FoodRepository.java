package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.MenuModel;

public interface FoodRepository extends JpaRepository<MenuModel, Integer> {

	public MenuModel findByFoodMenuItems(String itemName);

	public MenuModel findByFoodMenuID(int id);

}
