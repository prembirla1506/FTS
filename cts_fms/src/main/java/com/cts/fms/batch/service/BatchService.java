package com.cts.fms.batch.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fms.batch.dao.EventDetailsDao;
import com.cts.fms.batch.dao.EventNotAttendedDao;
import com.cts.fms.batch.dao.EventSummaryDao;
import com.cts.fms.batch.dao.EventUnregister;
import com.cts.fms.batch.dao.PocDetailsDao;
import com.cts.fms.batch.dto.EventNotApplicable;
import com.cts.fms.batch.dto.EventPocDetails;
import com.cts.fms.batch.dto.EventSummaryDetails;
import com.cts.fms.batch.model.EvengtNotAttended;
import com.cts.fms.batch.model.EventDetails;
import com.cts.fms.batch.model.EventSummary;
import com.cts.fms.batch.model.EventUnregistered;
import com.cts.fms.batch.model.PocDetails;
import com.cts.fms.utility.FmsUtility;

@Service
public class BatchService {

	@Autowired
	private EventDetailsDao eventDetailsDAo;

	@Autowired
	private PocDetailsDao posDetailsDao;
	
	@Autowired
	private EventSummaryDao eventSummaryDao;
	@Autowired
	private EventUnregister eventUnregister;
	@Autowired
	private EventNotAttendedDao eventNotAttended;
	

	List<EventDetails> listEventDetails = new ArrayList<EventDetails>();
	List<PocDetails> listPocDetails = new ArrayList<PocDetails>();
	List<EventSummary> listEtsmDetails = new ArrayList<EventSummary>();
	List<EventUnregistered> listEventUnregistered = new ArrayList<EventUnregistered>();
	List<EvengtNotAttended> listEventNotAttended = new ArrayList<EvengtNotAttended>();

	public void InsertIntoDataBase(List<EventPocDetails> listEventPocDetails) {

		listEventDetails = getListEventDetailsData(listEventPocDetails);

		listPocDetails = getListPocDetailsData(listEventPocDetails);
		
		saveEventDetails(listEventDetails);
		savePocDetails(listPocDetails);

	}

	private void savePocDetails(List<PocDetails> listPocDetails2) {
		posDetailsDao.saveAll(listPocDetails);
		
	}

	private void saveEventDetails(List<EventDetails> listEventDetails2) {
		eventDetailsDAo.saveAll(listEventDetails);
	}

	@Transactional
	private List<PocDetails> getListPocDetailsData(List<EventPocDetails> listEventDetailsObj) {

		List<PocDetails> listPocDetailsObj = new ArrayList<PocDetails>();

		for (EventPocDetails obj : listEventDetailsObj) {
			PocDetails pocObj = new PocDetails();

			pocObj.setPocId(obj.getPocId());
			pocObj.setPocEmail(obj.getPocEmail());
			pocObj.setPocName(obj.getPocName());
			listPocDetailsObj.add(pocObj);
		}

		return listPocDetailsObj;
	}

	private List<EventDetails> getListEventDetailsData(List<EventPocDetails> listEventDetailsObj) {

		List<EventDetails> listeventDetailsObj = new ArrayList<EventDetails>();
		
		

		for (EventPocDetails obj : listEventDetailsObj) {
			EventDetails objEt = new EventDetails();
			objEt.setEventID(obj.getEventID());
			objEt.setMonth(obj.getMonth());
			objEt.setBaseLocation(obj.getBaseLocation());
			objEt.setBenificialryName(obj.getBenificialryName());
			objEt.setVenueAddress(obj.getVenueAddress());
			objEt.setConuncilName(obj.getConuncilName());
			objEt.setProject(obj.getProject());
			objEt.setCategory(obj.getCategory());
			objEt.setEventName(obj.getEventName());
			objEt.setEventDescription(obj.getEventDescription());
			objEt.setEventDate(FmsUtility.stringToUtilDate(obj.getEventDate()));
			objEt.setTotalNoOfVolunteres(FmsUtility.parseDouble(obj.getTotalNoOfVolunteres()));
			objEt.setVoluntersHours(FmsUtility.parseDouble(obj.getVoluntersHours()));
			objEt.setTotalTravelHour(FmsUtility.parseDouble(obj.getTotalTravelHour()));
			objEt.setLivesImpacted(FmsUtility.parseDouble(obj.getLivesImpacted()));
			objEt.setActivityType(obj.getActivityType());
			objEt.setStatus(obj.getStatus());
			objEt.setPocId(obj.getPocId());
			objEt.setAllVolunteerHour(FmsUtility.parseDouble(obj.getAllVolunteerHour()));

			listeventDetailsObj.add(objEt);

		}
		return listeventDetailsObj;
	}

	public void InsertIntoDataBaseEventSummary(List<EventSummaryDetails> listEventDetails2) {
		
		listEtsmDetails = getListEventSummaryData(listEventDetails2);
		
		saveEventSummaryDetails(listEtsmDetails);
		
		
	}

	private void saveEventSummaryDetails(List<EventSummary> listEtsmDetails2) {
		eventSummaryDao.saveAll(listEtsmDetails2);
		
	}

	private List<EventSummary> getListEventSummaryData(List<EventSummaryDetails> listEventDetails2) {
		
		List<EventSummary> listObj = new ArrayList<EventSummary>();
		for (EventSummaryDetails obj : listEventDetails2) {
			EventSummary ref=new EventSummary();
			ref.setConuncilName(obj.getConuncilName());
			ref.setEventName(obj.getEventName());
			ref.setEventDescription(obj.getEventDescription());
			ref.setEventDate(FmsUtility.stringToUtilDate(obj.getEventDate()));
			ref.setEmployeeId(obj.getEmployeeId());
			ref.setEmployeeName(obj.getEmployeeName());
			ref.setVoluntersHours(FmsUtility.parseDouble(obj.getVoluntersHours()));
			ref.setTotalTravelHour(FmsUtility.parseDouble(obj.getTotalTravelHour()));
			ref.setLivesImpacted(FmsUtility.parseDouble(obj.getLivesImpacted()));
			ref.setBusineesUnit(obj.getBusineesUnit());
			ref.setStatus(obj.getStatus());
			ref.setIiepCategory(obj.getIiepCategory());
			ref.setEventID(getEventId(obj.getEventName()));
			listObj.add(ref);
		
		}
		
		return listObj;
	}
	
	private String getEventId(String eventName) {
		
		String eventId="";
		for (EventDetails obj : listEventDetails) {
			
			if(eventName.equals(obj.getEventName())){
				eventId=obj.getEventID();
				return eventId;
			}
		
		}
		
		return eventName;
		
		
	}

	public void InsertIntoDataBaseEventUnregistered(List<EventNotApplicable> listEventDetails2) {
			listEventUnregistered = getListEventunregisterData(listEventDetails2);
			
			saveEventUnregisterDetails(listEventUnregistered);
		
		
		
	}

	private void saveEventUnregisterDetails(List<EventUnregistered> listEventUnregistered2) {
		eventUnregister
		.saveAll(listEventUnregistered2);
	}

	private List<EventUnregistered> getListEventunregisterData(List<EventNotApplicable> listEventDetails2) {
		List<EventUnregistered> listObj = new ArrayList<EventUnregistered>();
		for (EventNotApplicable obj : listEventDetails2) {
			EventUnregistered ref =new EventUnregistered();
			ref.setEventID(obj.getEventID());
			ref.setEventName(obj.getEventName());
			ref.setEventDate(FmsUtility.stringToUtilDate(obj.getEventDate()));
			ref.setBaseLocation(obj.getBaseLocation());
			ref.setBenificialryName(obj.getBenificialryName());
			ref.setEmployeeId(obj.getEmployeeId());
			listObj.add(ref);
			
		}
		
		return listObj;
	}

	public void InsertIntoDataBaseEventNotAttended(List<EventNotApplicable> listEventDetails2) {
		listEventNotAttended = getListEventNotAttendData(listEventDetails2);
		
		saveEventNotAttendedDetails(listEventNotAttended);
		
	}

	private void saveEventNotAttendedDetails(List<EvengtNotAttended> listEventNotAttended2) {
		eventNotAttended.saveAll(listEventNotAttended2);
		
	}

	private List<EvengtNotAttended> getListEventNotAttendData(List<EventNotApplicable> listEventDetails2) {
		List<EvengtNotAttended> listObj = new ArrayList<EvengtNotAttended>();
		for (EventNotApplicable obj : listEventDetails2) {
			EvengtNotAttended ref =new EvengtNotAttended();
			ref.setEventID(obj.getEventID());
			ref.setEventName(obj.getEventName());
			ref.setEventDate(FmsUtility.stringToUtilDate(obj.getEventDate()));
			ref.setBaseLocation(obj.getBaseLocation());
			ref.setBenificialryName(obj.getBenificialryName());
			ref.setEmployeeId(obj.getEmployeeId());
			listObj.add(ref);
			
		}
		
		return listObj;
	}

}
