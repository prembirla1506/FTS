package com.cts.fms.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "user")
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	@JsonIgnore
	private String password;
	@Column
	private String employeeId;
	@Column
	private String emoplyeeName;
	@Column
	private double emprole;
	@Column
	private double empStatus;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmoplyeeName() {
		return emoplyeeName;
	}

	public void setEmoplyeeName(String emoplyeeName) {
		this.emoplyeeName = emoplyeeName;
	}

	public double getEmprole() {
		return emprole;
	}

	public void setEmprole(double emprole) {
		this.emprole = emprole;
	}

	public double getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(double empStatus) {
		this.empStatus = empStatus;
	}
	

}