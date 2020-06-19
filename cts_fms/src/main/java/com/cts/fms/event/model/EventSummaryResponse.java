package com.cts.fms.event.model;

import java.io.Serializable;
import java.util.List;

import com.cts.fms.batch.model.EvengtNotAttended;
import com.cts.fms.batch.model.EventSummary;
import com.cts.fms.batch.model.EventUnregistered;
import com.cts.fms.batch.model.PocDetails;

public class EventSummaryResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	public EventSummaryResponse() {
		super();
	}

	private List<EventSummary> eventSummary;
	private List<PocDetails> eventPocDetails;
	private List<EvengtNotAttended> eventNotAttended;
	private List<EventUnregistered> eventUnregister;
	
	
	public List<PocDetails> getEventPocDetails() {
		return eventPocDetails;
	}

	public void setEventPocDetails(List<PocDetails> eventPocDetails) {
		this.eventPocDetails = eventPocDetails;
	}

	public List<EvengtNotAttended> getEventNotAttended() {
		return eventNotAttended;
	}

	public void setEventNotAttended(List<EvengtNotAttended> eventNotAttended) {
		this.eventNotAttended = eventNotAttended;
	}

	public List<EventUnregistered> getEventUnregister() {
		return eventUnregister;
	}

	public void setEventUnregister(List<EventUnregistered> eventUnregister) {
		this.eventUnregister = eventUnregister;
	}

	public List<EventSummary> getEventSummary() {
		return eventSummary;
	}

	public void setEventSummary(List<EventSummary> eventSummary) {
		this.eventSummary = eventSummary;
	}
	
	

}
