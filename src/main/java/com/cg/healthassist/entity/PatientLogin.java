package com.cg.healthassist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class PatientLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true,updatable = false)
	private long loginId;
	
	public long getLoginId() {
		return loginId;
	}
	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	@Column(unique = true,updatable = false)
	@NotBlank(message="Patient Identifier can't be blank")
	@Size(min=4, max=5,message = "Size must be between 4 to 5 characters")
	private String patientIdentifier;
	private String password;
	public String getPatientIdentifier() {
		return patientIdentifier;
	}
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
