package com.cts.fms.respone;

import java.util.List;

import com.cts.fms.user.model.UserModel;

public class ResponseUser {
	
	private String statusCode;
	private String message;
	private List<UserModel> userData;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserModel> getUserModel() {
		return userData;
	}
	public void setUserModel(List<UserModel> userData) {
		this.userData = userData;
	}
	public ResponseUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseUser(String statusCode, String message, List<UserModel> userData) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.userData = userData;
	}
	@Override
	public String toString() {
		return "ResponseUser [statusCode=" + statusCode + ", message=" + message + ", userModel=" + userData + "]";
	}
	
	
	
	

}
