package com.cts.fms.event.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.fms.event.model.EventModel;

@Repository
public class FmsMasterDao {
	
	@Autowired
    EntityManagerFactory emf;
	private static final String event_sql=" select count(*) as total_event,sum(evnt.lives_impacted) as lives_impacted,"+
			" sum(evnt.total_no_of_volunteres) as total_volunteers , "+
			" ( sum(evnt.total_no_of_volunteres) +(select count(*) from event_notattended) "+
			" +(select count(*) from event_unregister) "+
			" ) as total_prticipants from entity_details evnt" ; 
			
	 public List<Object> getEventData()
	    {
		 
		 EntityManager em = emf.createEntityManager();
	        //em.getTransaction().begin( );

	        Query query =  em.createNativeQuery(event_sql);
	        List<Object> list =query.getResultList();
	        System.out.println("Student Name :");
	        em.close();

	        return list;
	    }
	 
	 
	

}
