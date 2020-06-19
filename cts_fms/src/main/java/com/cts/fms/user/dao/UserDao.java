package com.cts.fms.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fms.user.model.DAOUser;
import com.cts.fms.user.model.UserModel;

@Repository
public interface UserDao extends CrudRepository<UserModel, Long> {
	
	
	  @Query(value = "select * from user_details ",nativeQuery = true)
	  List<UserModel> findAllUsers();

}
