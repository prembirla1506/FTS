package com.cts.fms.batch.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.fms.batch.model.EvengtNotAttended;
import com.cts.fms.batch.model.EventSummary;

public interface EventNotAttendedDao extends CrudRepository<EvengtNotAttended, Long> {
	
	
	 List<EvengtNotAttended> findEventnotAttendedByeventID(String eventID);
	 List<EvengtNotAttended> findEventnotAttendedByemployeeId(String employeId);
	 
	 @Modifying
	 @Query(value = "update event_notattended set feedback='Y' where eventid=:eventId", nativeQuery = true)
	 @Transactional
	 int updateEventSummaryFeedback(@Param("eventId") String eventId);
	 
	 @Modifying
	 @Query(value = "update event_notattended set feedback='S' where eventid=:eventId and employee_id=:employeeId", nativeQuery = true)
	 @Transactional
	 int updateEventSummaryFeedbackEmployee(@Param("eventId") String eventId,@Param("employeeId") String employeeId);

}
