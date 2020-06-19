package com.cts.fms.event.model;

public class EmployeFeedbackDto {
	public EmployeFeedbackDto(){
		super();
	}
	
	private int rate;
	private String likecomment;
	private String improvecoment;
	private String eventId;
	private String employeeId;
	private int feedbackFor;
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getLikecomment() {
		return likecomment;
	}
	public void setLikecomment(String likecomment) {
		this.likecomment = likecomment;
	}
	public String getImprovecoment() {
		return improvecoment;
	}
	public void setImprovecoment(String improvecoment) {
		this.improvecoment = improvecoment;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getFeedbackFor() {
		return feedbackFor;
	}
	public void setFeedbackFor(int feedbackFor) {
		this.feedbackFor = feedbackFor;
	}
	
	
	
}
