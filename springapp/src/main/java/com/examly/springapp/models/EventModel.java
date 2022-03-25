package com.examly.springapp.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class EventModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence-generator")
	private int eventId;
	
	@Column(nullable=false, unique=true,length=20)
	private String eventName;
	
	@Column(nullable=false, length=30)
	private String applicantName;
	
	@Column(nullable=false, length=80)
	private String applicantAddress;
	
	@Column(nullable=false, length=10)
	private String applicantMobile;
	
	@Column(nullable=false,length=30)
	private String applicantEmail;
	
	@Column(nullable=false, length=80)
	private String eventAddress;
	
	@Column(nullable=false)
	private LocalDate eventDate;
	
	@Column(nullable=false)
	private LocalTime eventTime;
	
	@Column()
	private int eventMenuId;
	
	@Column(nullable=false)
	private int addonId;
	
	@Column(nullable=false,length=10)
	private String EventCost;

	public EventModel() {
		
	}

	public EventModel(int eventId, String eventName, String applicantName, String applicantAddress,
			String applicantMobile, String applicantEmail, String eventAddress, LocalDate eventDate, LocalTime eventTime,
			int eventMenuId, int addonId, String eventCost) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.applicantName = applicantName;
		this.applicantAddress = applicantAddress;
		this.applicantMobile = applicantMobile;
		this.applicantEmail = applicantEmail;
		this.eventAddress = eventAddress;
		this.eventDate = eventDate;
		this.eventTime = eventTime;
		this.eventMenuId = eventMenuId;
		this.addonId = addonId;
		this.EventCost = eventCost;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public String getApplicantMobile() {
		return applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		this.applicantMobile = applicantMobile;
	}

	public String getApplicantEmail() {
		return applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}

	public int getEventMenuId() {
		return eventMenuId;
	}

	public void setEventMenuId(int eventMenuId) {
		this.eventMenuId = eventMenuId;
	}

	public int getAddonId() {
		return addonId;
	}

	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}

	public String getEventCost() {
		return EventCost;
	}

	public void setEventCost(String eventCost) {
		this.EventCost = eventCost;
	}
}
