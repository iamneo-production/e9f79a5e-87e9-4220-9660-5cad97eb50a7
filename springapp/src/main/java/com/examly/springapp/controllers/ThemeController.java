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

import com.examly.springapp.models.ThemeModel;
import com.examly.springapp.services.ThemeService;

@RestController
@RequestMapping
public class ThemeController {

	@Autowired
	ThemeService themeService;
	
	@PostMapping("/admin/addTheme")
	public ThemeModel addTheme(@RequestBody ThemeModel theme) throws Exception {
		String tempName = theme.getThemeName();
		if(themeService.fetchByName(tempName) != null) {
			throw new Exception("theme with name"+tempName+"already exist");
		}
		return themeService.saveTheme(theme);
	}

	@GetMapping("/admin/getTheme/{id}")
	public ThemeModel getTheme(@PathVariable int id) throws Exception {
		ThemeModel theme = themeService.fetchById(id);
		if(theme == null) {
			throw new Exception("id not found");
		}
		return theme;
	}
	
	@PutMapping("/admin/editTheme/{id}")
	public ThemeModel editTheme(@RequestBody ThemeModel themeDetails, @PathVariable int id) throws Exception {
		ThemeModel tempTheme = themeService.fetchById(id);
		if(tempTheme == null) {
			throw new Exception("id not found");
		}
		tempTheme.setThemeCost(themeDetails.getThemeCost());
		tempTheme.setThemeDescription(themeDetails.getThemeDescription());
		tempTheme.setThemeImageURL(themeDetails.getThemeImageURL());
		tempTheme.setThemeName(themeDetails.getThemeName());
		tempTheme.setThemePhotographer(themeDetails.getThemePhotographer());
		tempTheme.setThemeReturnGift(themeDetails.getThemeReturnGift());
		tempTheme.setThemeVideographer(themeDetails.getThemeVideographer());
		themeService.saveTheme(tempTheme);
		return tempTheme;
	}
	
	@DeleteMapping("/admin/deleteTheme/{id}")
	public String deleteTheme(@PathVariable int id) throws Exception {
		if(themeService.fetchById(id) == null) {
			throw new Exception("id not found");
		}
		themeService.deleteThemeById(id);
		return ("deleted Sucessfully");
	}
}

