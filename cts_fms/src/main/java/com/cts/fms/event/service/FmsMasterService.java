package com.cts.fms.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.fms.batch.dao.EventDetailsDao;
import com.cts.fms.batch.dao.EventNotAttendedDao;
import com.cts.fms.batch.dao.EventSummaryDao;
import com.cts.fms.batch.dao.EventUnregister;
import com.cts.fms.batch.dao.PocDetailsDao;
import com.cts.fms.batch.model.EmployeFeedback;
import com.cts.fms.batch.model.EvengtNotAttended;
import com.cts.fms.batch.model.EventDetails;
import com.cts.fms.batch.model.EventSummary;
import com.cts.fms.batch.model.EventUnregistered;
import com.cts.fms.batch.model.PocDetails;
import com.cts.fms.event.dao.EmployeFeedbackDao;
import com.cts.fms.event.dao.EventDao;
import com.cts.fms.event.dao.FmsMasterDao;
import com.cts.fms.event.model.EmployeFeedbackDto;
import com.cts.fms.event.model.EventModel;

@Service
public class FmsMasterService {

	@Autowired
	private FmsMasterDao fmsMasterDao;

	@Autowired
	private EventDetailsDao eventDetailsDao;

	@Autowired
	private EventNotAttendedDao eventNotAttended;

	@Autowired
	private EventSummaryDao eventSummaryDao;

	@Autowired
	private EventUnregister eventUnregister;

	@Autowired
	private PocDetailsDao pocDetailsDao;

	@Autowired
	private EmployeFeedbackDao employeFeedbackDao;

	public List<Object> getEventData() {
		return fmsMasterDao.getEventData();
	}

	public List<EventDetails> getEventDetails() {
		return eventDetailsDao.findAll();

	}

	public List<EventSummary> getEventSummaryByEvent(String eventId) {
		return eventSummaryDao.findEventSummaryByeventID(eventId);

	}

	public List<EventUnregistered> getEventUnregisterByEvent(String eventId) {
		return eventUnregister.findEventUnregisteredByeventID(eventId);

	}

	public List<EvengtNotAttended> getEventNotAttendedByEvent(String eventId) {
		return eventNotAttended.findEventnotAttendedByeventID(eventId);

	}

	public List<PocDetails> getEventPocBypoccId(String pocId) {
		return pocDetailsDao.findEventPocBypocId(pocId);

	}

	public int submitFeedbackSummary(String evnetId) {

		return eventSummaryDao.updateEventSummaryFeedback(evnetId);

	}

	public int submitFeedbackNotAttended(String evnetId) {

		return eventNotAttended.updateEventSummaryFeedback(evnetId);

	}

	public int submitFeedbackUnregiser(String evnetId) {

		return eventUnregister.updateEventSummaryFeedback(evnetId);

	}

	public List<EventSummary> getEventSummaryByEmploye(String employeId) {
		return eventSummaryDao.findEventSummaryByemployeeId(employeId);

	}

	public List<EventUnregistered> getEventUnregisterByEmployee(String employeId) {
		return eventUnregister.findEventUnregisteredByemployeeId(employeId);

	}

	public List<EvengtNotAttended> getEventNotAttendedByEmployee(String employeId) {
		return eventNotAttended.findEventnotAttendedByemployeeId(employeId);

	}

	@Transactional
	public EmployeFeedback submitFeedback(EmployeFeedbackDto dto) {
		EmployeFeedback obj = new EmployeFeedback();
		obj.setEmployeeId(dto.getEmployeeId());
		obj.setEventId(dto.getEventId());
		obj.setFeedbackFor(dto.getFeedbackFor());
		obj.setImprovecoment(dto.getImprovecoment());
		obj.setLikecomment(dto.getLikecomment());
		obj.setRate(dto.getRate());

		if (dto.getFeedbackFor() == 1) {
			eventSummaryDao.updateEventSummaryFeedbackEmployee(dto.getEventId(), dto.getEmployeeId());
		} else if (dto.getFeedbackFor() == 2) {
			eventNotAttended.updateEventSummaryFeedbackEmployee(dto.getEventId(), dto.getEmployeeId());
		}

		else {
			eventUnregister.updateEventSummaryFeedbackEmployee(dto.getEventId(), dto.getEmployeeId());
		}

		return employeFeedbackDao.save(obj);
	}

}
