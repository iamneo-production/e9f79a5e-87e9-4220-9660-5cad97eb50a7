package com.examly.springapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class MenuModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence-generator")
	private int foodMenuID;
	
	@Column(nullable=false)
	private String foodMenuType;
	
	@Column(nullable=false, unique=true)
	private String foodMenuItems;
	
	@Column(nullable=false, length=10)
	private String foodMenuCost;

	public MenuModel() {
		
	}
	public MenuModel(int foodMenuID, String foodMenuType, String foodMenuItems, String foodMenuCost) {
		super();
		this.foodMenuID = foodMenuID;
		this.foodMenuType = foodMenuType;
		this.foodMenuItems = foodMenuItems;
		this.foodMenuCost = foodMenuCost;
	}
	public int getFoodMenuID() {
		return foodMenuID;
	}
	public void setFoodMenuID(int foodMenuID) {
		this.foodMenuID = foodMenuID;
	}
	public String getFoodMenuType() {
		return foodMenuType;
	}
	public void setFoodMenuType(String foodMenuType) {
		this.foodMenuType = foodMenuType;
	}
	public String getFoodMenuItems() {
		return foodMenuItems;
	}
	public void setFoodMenuItem(String foodMenu) {
		this.foodMenuItems = foodMenu;
	}
	public String getFoodMenuCost() {
		return foodMenuCost;
	}
	public void setFoodMenuCost(String foodMenuCost) {
		this.foodMenuCost = foodMenuCost;
	}
	
	
}
