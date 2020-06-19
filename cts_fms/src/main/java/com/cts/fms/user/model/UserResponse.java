package com.cts.fms.user.model;

import java.io.Serializable;
import java.util.List;

public class UserResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	public UserResponse(){
		super();
	}
	
	private List<DAOUser> users;

	public List<DAOUser> getUsers() {
		return users;
	}

	public void setUsers(List<DAOUser> users) {
		this.users = users;
	}
	
	
}
