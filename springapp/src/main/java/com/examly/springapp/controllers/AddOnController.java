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

import com.examly.springapp.models.AddOnModel;
import com.examly.springapp.services.AddOnService;

@RestController
@RequestMapping
public class AddOnController {

	@Autowired
	private AddOnService addOnService;
	
	
	@PostMapping("/admin/addAddon")
	public AddOnModel addAddon(@RequestBody AddOnModel addonDetails) throws Exception {
		String tempName = addonDetails.getAddonName();
		AddOnModel addOnObj = addOnService.findByName(tempName);
		if(addOnObj != null) {
			throw new Exception("name already exist");
		}
		addOnObj = addOnService.saveAddOn(addonDetails);
		return addOnObj;
	}
	
	@GetMapping("/admin/getAddOn/{id}")
	public AddOnModel getAddOn(@PathVariable int id) throws Exception {
		AddOnModel addOnObj = addOnService.fetchById(id);
		if(addOnObj == null) {
			throw new Exception("id not found");
		}
		return addOnObj;
	}
	
	@PutMapping("/admin/editAddOn/{id}")
	public AddOnModel editAddOn(@RequestBody AddOnModel addOnDetails, @PathVariable int id) throws Exception {
		AddOnModel addOnObj = addOnService.fetchById(id);
		if(addOnObj == null) {
			throw new Exception("id not found");
		}
		if(addOnService.findByName(addOnDetails.getAddonName()) != null) {
			throw new Exception("addOn name already exist");
		}
		addOnObj.setAddAddonPrice(addOnDetails.getAddAddonPrice());
		addOnObj.setAddonDescription(addOnDetails.getAddonDescription());
		addOnObj.setAddonName(addOnDetails.getAddonName());
		return addOnService.saveAddOn(addOnObj);
	}
	
	@DeleteMapping("/admin/deleteAddOn/{id}")
	public String deleteAddOn(@PathVariable int id) throws Exception {
		if(addOnService.fetchById(id) == null) {
			throw new Exception("id not found");
		}
		addOnService.deleteAddOn(id);
		return ("deleted Sucessfully");
	}
}
