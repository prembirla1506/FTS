package com.cts.fms.event.model;

import java.io.Serializable;
import java.util.List;

public class EventModelResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	public EventModelResponse() {
		super();
		
	}
	private String message;
	private EventModel eventData;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EventModel getEventData() {
		return eventData;
	}
	public void setEventData(EventModel eventData) {
		this.eventData = eventData;
	}
	
	
	

}
