package com.cts.fms.batch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="employee_feedback")
public class EmployeFeedback {
	public EmployeFeedback(){
		super();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private int rate;
	private String likecomment;
	private String improvecoment;
	private String eventId;
	private String employeeId;
	private int feedbackFor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
