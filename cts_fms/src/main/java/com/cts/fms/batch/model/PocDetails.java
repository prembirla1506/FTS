package com.cts.fms.batch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="poc_Details")
public class PocDetails {
	
	public PocDetails (){
		super();
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String pocId;
	private String pocName;
	private String pocEmail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPocId() {
		return pocId;
	}
	public void setPocId(String pocId) {
		this.pocId = pocId;
	}
	public String getPocName() {
		return pocName;
	}
	public void setPocName(String pocName) {
		this.pocName = pocName;
	}
	public String getPocEmail() {
		return pocEmail;
	}
	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}
	

	
	
}
