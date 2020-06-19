package com.cts.fms.batch.dto;

public class EventNotApplicable {
	
	private String eventID;
	private String eventName;
	private String benificialryName;
	private String eventDate;
	private String employeeId;
	private String baseLocation;
	
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
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
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
