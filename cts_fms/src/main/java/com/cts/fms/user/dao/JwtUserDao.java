package com.cts.fms.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cts.fms.user.model.DAOUser;

public interface JwtUserDao extends CrudRepository<DAOUser, Long> {

	DAOUser findByUsername(String username);
	
	List<DAOUser> findAll();

	DAOUser findAllById(Long id);
	
	

}
