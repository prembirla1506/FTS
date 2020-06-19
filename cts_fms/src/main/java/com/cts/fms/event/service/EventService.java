package com.cts.fms.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fms.event.dao.EventDao;
import com.cts.fms.event.model.EventModel;

@Service
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	public EventModel getEventData() {
		return eventDao.findEventData();
	}

}
