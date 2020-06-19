package com.cts.fms.user.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fms.respone.ResponseUser;
import com.cts.fms.user.model.UserModel;
import com.cts.fms.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public  ResponseUser getUser() {
		
		List<UserModel> useList=userService.getAllUser();
		System.out.println("useList "+useList);
		return new ResponseUser("200", "GOt USer", useList);
	}
	

}
