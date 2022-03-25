package com.examly.springapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addons")
public class AddOnModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence-generator")
	private int addonId;
	
	@Column(nullable=false, unique=true, length=30)
	private String addonName;
	
	@Column(nullable=false, unique=true, length=80)
	private String addonImageUrl;
	
	@Column(nullable=false, length=10)
	private String AddAddonPrice;

	public AddOnModel() {
		
	}
	public AddOnModel(int addonId, String addonName, String addonImageUrl, String addAddonPrice) {
		super();
		this.addonId = addonId;
		this.addonName = addonName;
		this.addonImageUrl = addonImageUrl;
		this.AddAddonPrice = addAddonPrice;
	}
	public int getAddonId() {
		return addonId;
	}
	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}
	public String getAddonName() {
		return addonName;
	}
	public void setAddonName(String addonName) {
		this.addonName = addonName;
	}
	public String getAddonDescription() {
		return addonImageUrl;
	}
	public void setAddonDescription(String addonImageUrl) {
		this.addonImageUrl = addonImageUrl;
	}
	public String getAddAddonPrice() {
		return AddAddonPrice;
	}
	public void setAddAddonPrice(String addAddonPrice) {
		this.AddAddonPrice = addAddonPrice;
	}
	
}
