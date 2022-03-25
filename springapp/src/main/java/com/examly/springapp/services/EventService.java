package com.examly.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.models.EventModel;
import com.examly.springapp.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepo;

	public EventModel saveEvent(EventModel eventDetails) {
		return eventRepo.save(eventDetails);	
	}

	public EventModel fetchById(int id) {
		return eventRepo.findByEventId(id);
	}

	public void deleteEventById(int id) {
		eventRepo.deleteById(id);
		
	}

	
}
