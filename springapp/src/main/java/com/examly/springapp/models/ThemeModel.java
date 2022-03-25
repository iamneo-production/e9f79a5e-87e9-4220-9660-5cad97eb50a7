package com.examly.springapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="themes")
public class ThemeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int themeId;
	
	@Column(nullable=false, unique=true)
	private String themeName;
	
	@Column(nullable=false)
	private String themeImageURL;
	
	@Column(nullable=false)
	private String themeDescription;
	
	@Column(nullable=false)
	private String themePhotographer;
	
	@Column(nullable=false)
	private String themeVideographer;
	
	@Column(nullable=false)
	private String ThemeReturnGift;
	
	@Column(nullable=false)
	private Long ThemeCost;

	public ThemeModel() {
		
	}
	
	public ThemeModel(int themeId, String themeName, String themeImageURL, String themeDescription,
			String themePhotographer, String themeVideographer, String themeReturnGift, Long themeCost) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
		this.themeImageURL = themeImageURL;
		this.themeDescription = themeDescription;
		this.themePhotographer = themePhotographer;
		this.themeVideographer = themeVideographer;
		ThemeReturnGift = themeReturnGift;
		ThemeCost = themeCost;
	}

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getThemeImageURL() {
		return themeImageURL;
	}

	public void setThemeImageURL(String themeImageURL) {
		this.themeImageURL = themeImageURL;
	}

	public String getThemeDescription() {
		return themeDescription;
	}

	public void setThemeDescription(String themeDescription) {
		this.themeDescription = themeDescription;
	}

	public String getThemePhotographer() {
		return themePhotographer;
	}

	public void setThemePhotographer(String themePhotographer) {
		this.themePhotographer = themePhotographer;
	}

	public String getThemeVideographer() {
		return themeVideographer;
	}

	public void setThemeVideographer(String themeVideographer) {
		this.themeVideographer = themeVideographer;
	}

	public String getThemeReturnGift() {
		return ThemeReturnGift;
	}

	public void setThemeReturnGift(String themeReturnGift) {
		ThemeReturnGift = themeReturnGift;
	}

	public Long getThemeCost() {
		return ThemeCost;
	}

	public void setThemeCost(Long themeCost) {
		ThemeCost = themeCost;
	}
	
	
}
