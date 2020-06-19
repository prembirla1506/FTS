package com.cts.fms.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="event_unregister")
public class EventUnregistered {

	public EventUnregistered (){
		super();
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String eventID;
	private String eventName;
	private String benificialryName;
	private Date eventDate;
	private String employeeId;
	private String baseLocation;
	private String feedback;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getBenificialryName() {
		return benificialryName;
	}
	public void setBenificialryName(String benificialryName) {
		this.benificialryName = benificialryName;
	}
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
}
