package com.cts.fms.event.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.fms.batch.model.EmployeFeedback;

public interface EmployeFeedbackDao extends CrudRepository<EmployeFeedback, Long> {

}
