package com.cts.fms.event.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EventModel {
	public EventModel() {
		super();
		
	}
	
	private BigInteger totalEvent;
	private double livesImpacted;
	
	
	
	
	public BigInteger getTotalEvent() {
		return totalEvent;
	}
	public void setTotalEvent(BigInteger totalEvent) {
		this.totalEvent = totalEvent;
	}
	public double getLivesImpacted() {
		return livesImpacted;
	}
	public void setLivesImpacted(double livesImpacted) {
		this.livesImpacted = livesImpacted;
	}
	public double getTotalVolunteers() {
		return totalVolunteers;
	}
	public void setTotalVolunteers(double totalVolunteers) {
		this.totalVolunteers = totalVolunteers;
	}
	public double getTotalPrticipants() {
		return totalPrticipants;
	}
	public void setTotalPrticipants(double totalPrticipants) {
		this.totalPrticipants = totalPrticipants;
	}

	private double totalVolunteers;
	private double totalPrticipants;
	
	
	
	
	

}
