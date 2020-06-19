package com.cts.fms.batch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fms.batch.model.EventDetails;

@Repository
public interface EventDetailsDao extends CrudRepository<EventDetails, Long> {
	
	public List<EventDetails> findAll();

}
