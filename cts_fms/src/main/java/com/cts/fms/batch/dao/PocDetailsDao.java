package com.cts.fms.batch.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fms.batch.model.EventUnregistered;
import com.cts.fms.batch.model.PocDetails;

@Repository
public interface PocDetailsDao extends CrudRepository<PocDetails, Long>{

	
	 List<PocDetails> findEventPocBypocId(String pocId);
}
