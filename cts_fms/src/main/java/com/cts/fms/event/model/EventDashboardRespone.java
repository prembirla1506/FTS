package com.cts.fms.event.model;

import java.io.Serializable;
import java.util.List;

import com.cts.fms.batch.model.EventDetails;

public class EventDashboardRespone  implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	public EventDashboardRespone() {
		super();
		
	}

	private List<EventDetails> eventDashboard;
	public List<EventDetails> getEventDashboard() {
		return eventDashboard;
	}

	public void setEventDashboard(List<EventDetails> eventDashboard) {
		this.eventDashboard = eventDashboard;
	}
	
	
	
}
