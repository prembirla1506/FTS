package com.cts.fms.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="event_summary")
public class EventSummary {
	public EventSummary (){
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String eventID;
	private String conuncilName;
	private String eventName;
	private String eventDescription;
	private Date eventDate;
	private double totalTravelHour;
	private double voluntersHours;
	private double livesImpacted;
	private String status;
	private String employeeId;
	private String employeeName;
	private String busineesUnit;
	private String iiepCategory;
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
	public String getConuncilName() {
		return conuncilName;
	}
	public void setConuncilName(String conuncilName) {
		this.conuncilName = conuncilName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getBusineesUnit() {
		return busineesUnit;
	}
	public void setBusineesUnit(String busineesUnit) {
		this.busineesUnit = busineesUnit;
	}
	public String getIiepCategory() {
		return iiepCategory;
	}
	public void setIiepCategory(String iiepCategory) {
		this.iiepCategory = iiepCategory;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public double getTotalTravelHour() {
		return totalTravelHour;
	}
	public void setTotalTravelHour(double totalTravelHour) {
		this.totalTravelHour = totalTravelHour;
	}
	public double getVoluntersHours() {
		return voluntersHours;
	}
	public void setVoluntersHours(double voluntersHours) {
		this.voluntersHours = voluntersHours;
	}
	public double getLivesImpacted() {
		return livesImpacted;
	}
	public void setLivesImpacted(double livesImpacted) {
		this.livesImpacted = livesImpacted;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
}
