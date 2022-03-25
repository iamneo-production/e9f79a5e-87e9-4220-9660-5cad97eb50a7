package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.ThemeModel;

public interface ThemeRepository extends JpaRepository<ThemeModel, Integer> {

	public ThemeModel findByThemeName(String themeName);
	
	public ThemeModel findById(int id);
}
