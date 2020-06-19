package com.cts.fms.batch.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.fms.batch.model.EventSummary;
import com.cts.fms.user.model.UserModel;

@Repository
public interface EventSummaryDao extends CrudRepository<EventSummary, Long> {
	
	 @Query(value = "SELECT * FROM fmsdbs.event_summary where eventid='EVNT00046103' ",nativeQuery = true)
	  List<EventSummary> findEventSummary();
	 
	 List<EventSummary> findEventSummaryByeventID(String eventID);
	 
	 
	 @Modifying
	 @Query(value = "update event_summary set feedback='Y' where eventid=:eventId", nativeQuery = true)
	 @Transactional
	 int updateEventSummaryFeedback(@Param("eventId") String eventId);
	 
	 
	 @Modifying
	 @Query(value = "update event_summary set feedback='S' where eventid=:eventId and employee_id=:employeeId", nativeQuery = true)
	 @Transactional
	 int updateEventSummaryFeedbackEmployee(@Param("eventId") String eventId,@Param("employeeId") String employeeId);
	 
	 
	 List<EventSummary> findEventSummaryByemployeeId(String employeId);
	 
	 
	 

}
