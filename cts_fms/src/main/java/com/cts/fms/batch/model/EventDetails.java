package com.cts.fms.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="entity_details")
public class EventDetails {
	public EventDetails(){
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String eventID;
	private String month;
	private String baseLocation;
	private String benificialryName;
	private String venueAddress;
	private String conuncilName;
	private String project;
	private String category;
	private String eventName;
	private String eventDescription;
	private Date eventDate;
	private double totalNoOfVolunteres;
	private double totalTravelHour;
	private double voluntersHours;
	private double allVolunteerHour;
	private double livesImpacted;
	private String activityType;
	private String status;
	
	public String getPocId() {
		return pocId;
	}
	public void setPocId(String pocId) {
		this.pocId = pocId;
	}

	private String pocId;
	
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public String getBenificialryName() {
		return benificialryName;
	}
	public void setBenificialryName(String benificialryName) {
		this.benificialryName = benificialryName;
	}
	public String getVenueAddress() {
		return venueAddress;
	}
	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}
	public String getConuncilName() {
		return conuncilName;
	}
	public void setConuncilName(String conuncilName) {
		this.conuncilName = conuncilName;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	
	public double getTotalNoOfVolunteres() {
		return totalNoOfVolunteres;
	}
	public void setTotalNoOfVolunteres(double totalNoOfVolunteres) {
		this.totalNoOfVolunteres = totalNoOfVolunteres;
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
	public double getAllVolunteerHour() {
		return allVolunteerHour;
	}
	public void setAllVolunteerHour(double allVolunteerHour) {
		this.allVolunteerHour = allVolunteerHour;
	}
	public double getLivesImpacted() {
		return livesImpacted;
	}
	public void setLivesImpacted(double livesImpacted) {
		this.livesImpacted = livesImpacted;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", eventID=" + eventID + ", month=" + month + ", baseLocation=" + baseLocation
				+ ", benificialryName=" + benificialryName + ", venueAddress=" + venueAddress + ", conuncilName="
				+ conuncilName + ", project=" + project + ", category=" + category + ", eventName=" + eventName
				+ ", eventDescription=" + eventDescription + ", eventDate=" + eventDate + ", totalNoOfVolunteres="
				+ totalNoOfVolunteres + ", totalTravelHour=" + totalTravelHour + ", voluntersHours=" + voluntersHours
				+ ", allVolunteerHour=" + allVolunteerHour + ", livesImpacted=" + livesImpacted + ", activityType="
				+ activityType + ", status=" + status + "]";
	}
	
	
	

}
