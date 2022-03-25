package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.EventModel;

public interface EventRepository extends JpaRepository<EventModel, Integer> {

	public EventModel findByEventId(int id);

}
