package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.AddOnModel;
import com.examly.springapp.repository.AddOnRepository;

@Service
public class AddOnService {

	@Autowired
	private AddOnRepository addOnRepo;
	
	public AddOnModel findByName(String name) {
		return addOnRepo.findByAddonName(name);
	}

	public AddOnModel saveAddOn(AddOnModel addonDetails) {
		return addOnRepo.save(addonDetails);
	}

	public AddOnModel fetchById(int id) {
		return addOnRepo.findByAddonId(id);
	}

	public void deleteAddOn(int id) {
		addOnRepo.deleteById(id);
		
	}

	
}
