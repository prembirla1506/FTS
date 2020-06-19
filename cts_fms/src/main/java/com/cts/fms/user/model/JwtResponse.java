package com.cts.fms.user.model;


import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final DAOUser  user;
	public String getJwttoken() {
		return jwttoken;
	}
	public DAOUser getUser() {
		return user;
	}
	public JwtResponse(String jwttoken, DAOUser user) {
		super();
		this.jwttoken = jwttoken;
		this.user = user;
	}
	
	
	

}