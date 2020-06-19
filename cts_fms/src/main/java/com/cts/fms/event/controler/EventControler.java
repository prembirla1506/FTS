package com.cts.fms.event.controler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fms.event.model.EmployeFeedbackDto;
import com.cts.fms.event.model.EventDashboardRespone;
import com.cts.fms.event.model.EventModel;
import com.cts.fms.event.model.EventModelResponse;
import com.cts.fms.event.model.EventSummaryResponse;
import com.cts.fms.event.model.SubmitFeedbackResponse;
import com.cts.fms.event.service.EventService;
import com.cts.fms.event.service.FmsMasterService;
import com.cts.fms.user.model.UserDTO;

@RestController
@CrossOrigin(origins = "http://localhost:8088")
public class EventControler {
	@Autowired
	private EventService eventService;
	@Autowired
	private FmsMasterService fmsMasterService;

	@GetMapping("/eventData")
	public ResponseEntity<?> getEventData() {
		List<EventModel> list = new ArrayList<EventModel>();
		List<Object> eventData = fmsMasterService.getEventData();
		EventModel ref = new EventModel();
		EventModelResponse response = new EventModelResponse();
		Iterator itr = eventData.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			ref.setLivesImpacted((double) obj[1]);
			ref.setTotalEvent((BigInteger) obj[0]);
			ref.setTotalPrticipants((double) obj[3]);
			ref.setTotalVolunteers((double) obj[2]);
		}
		response.setEventData(ref);
		response.setMessage("success");
		return ResponseEntity.ok(response);
	}

	@GetMapping("/eventDashboard")
	public ResponseEntity<?> getEventDetails() {
		EventDashboardRespone response = new EventDashboardRespone();
		response.setEventDashboard(fmsMasterService.getEventDetails());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/eventSummary")
	public ResponseEntity<?> getEventSummary(@RequestParam(name = "eventId") String eventId,
			@RequestParam(name = "pocId") String pocId) {
		EventSummaryResponse response = new EventSummaryResponse();
		response.setEventSummary(fmsMasterService.getEventSummaryByEvent(eventId));
		response.setEventNotAttended(fmsMasterService.getEventNotAttendedByEvent(eventId));
		response.setEventUnregister(fmsMasterService.getEventUnregisterByEvent(eventId));
		response.setEventPocDetails(fmsMasterService.getEventPocBypoccId(pocId));
		return ResponseEntity.ok(response);
	}

	@GetMapping("/submitFeedback")
	public ResponseEntity<?> submitFeedback(@RequestParam(name = "eventId") String eventId) {
		SubmitFeedbackResponse response = new SubmitFeedbackResponse();
		response.setSummaryFeedbackCount(fmsMasterService.submitFeedbackSummary(eventId));
		response.setNaFeedbackCount(fmsMasterService.submitFeedbackNotAttended(eventId));
		response.setUnFeedbackCount(fmsMasterService.submitFeedbackUnregiser(eventId));
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/eventSummaryByEmployeID")
	public ResponseEntity<?> getEventSummaryByEmployeID(@RequestParam(name = "employeId") String employeID) {
		EventSummaryResponse response = new EventSummaryResponse();
		response.setEventSummary(fmsMasterService.getEventSummaryByEmploye(employeID));
		response.setEventNotAttended(fmsMasterService.getEventNotAttendedByEmployee(employeID));
		response.setEventUnregister(fmsMasterService.getEventUnregisterByEmployee(employeID));
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/feedbackSubmitted", method = RequestMethod.POST)
	public ResponseEntity<?> feedbackSubmitted(@RequestBody EmployeFeedbackDto employeFeedbackDto) {
		EventSummaryResponse response = new EventSummaryResponse();
		return ResponseEntity.ok(fmsMasterService.submitFeedback(employeFeedbackDto));
	}
}
