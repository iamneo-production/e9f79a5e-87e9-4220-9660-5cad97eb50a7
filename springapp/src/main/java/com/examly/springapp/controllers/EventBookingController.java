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

import com.examly.springapp.models.EventModel;
import com.examly.springapp.services.EventService;


@RestController
@RequestMapping
public class EventBookingController {

	@Autowired
	private EventService eventService;
	
	
	@PostMapping("/user/bookEvent")
	public EventModel bookEvent(@RequestBody EventModel eventDetails) {
		return eventService.saveEvent(eventDetails);
	}
	
	@GetMapping("/user/viewEvent")
	public EventModel viewEvent(@PathVariable int id) throws Exception {
		EventModel eventObj = eventService.fetchById(id);
		if(eventObj == null) {
			throw new Exception("id not found");
		}
		return eventObj;
	}
	
	@PutMapping("/user/editEvent")
	public EventModel editEvent(@RequestBody EventModel eventDetails, @PathVariable int id) throws Exception {
		EventModel eventObj = eventService.fetchById(id);
		if(eventObj == null) {
			throw new Exception("id not found");
		}
		eventObj.setEventName(eventDetails.getEventName());
		eventObj.setEventAddress(eventDetails.getEventAddress());
		eventObj.setEventCost(eventDetails.getEventCost());
		eventObj.setEventDate(eventDetails.getEventDate());
		eventObj.setEventTime(eventDetails.getEventTime());
		eventObj.setApplicantName(eventDetails.getApplicantAddress());
		eventObj.setApplicantAddress(eventDetails.getApplicantAddress());
		eventObj.setApplicantEmail(eventDetails.getApplicantEmail());
		eventObj.setApplicantMobile(eventDetails.getApplicantMobile());
		eventObj.setAddonId(eventDetails.getAddonId());
		eventObj.setEventMenuId(eventDetails.getEventMenuId());
		
		return eventService.saveEvent(eventObj);
	}
	
	@DeleteMapping("/user/deleteEvent")
	public String deleteEvent(@PathVariable int id) throws Exception {
		EventModel eventObj = eventService.fetchById(id);
		if(eventObj == null) {
			throw new Exception("id not found");
		}
		eventService.deleteEventById(id);
		return ("deleted sucessfully");
	}
	
	
}
