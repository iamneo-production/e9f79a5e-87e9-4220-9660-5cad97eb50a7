package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.models.AddOnModel;

@Repository
public interface AddOnRepository extends JpaRepository<AddOnModel, Integer> {

	public AddOnModel findByAddonName(String name);

	public AddOnModel findByAddonId(int id);

}
