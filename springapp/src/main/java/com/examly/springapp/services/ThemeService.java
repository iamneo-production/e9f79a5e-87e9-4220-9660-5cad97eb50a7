package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.ThemeModel;
import com.examly.springapp.repository.ThemeRepository;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository themeRepo;

	public ThemeModel saveTheme(ThemeModel theme) {
		 return themeRepo.save(theme);
	}
	
	public ThemeModel fetchByName(String themeName) {
		return themeRepo.findByThemeName(themeName);
	}

	public ThemeModel fetchById(int id) {
		return themeRepo.findById(id);
		
	}

	public void deleteThemeById(int id) {
		themeRepo.deleteById(id);
		
	}
}
