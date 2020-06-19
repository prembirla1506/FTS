package com.cts.fms.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fms.user.dao.UserDao;
import com.cts.fms.user.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<UserModel> getAllUser(){
		
	List<UserModel> userList=userDao.findAllUsers();
	System.out.println("useList "+userList);
	return userList;
	}
	
	

}
