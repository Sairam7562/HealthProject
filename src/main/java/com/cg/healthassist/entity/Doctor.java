package com.cg.healthassist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

public class Doctor{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long doctorId;
	private String doctorName;
	@Column(unique = true,updatable = false)
	@NotBlank(message="Doctor Identifier can't be blank")
	@Size(min=4, max=5,message = "Size must be between 4 to 5 characters")
	private String identifier;
	
	
	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	private String hospitalId;
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	private String specialization;
	private long doctorPhNo;
	
	public Doctor(String doctorName, String specialization, long doctorPhNo,String identifier,String hospitalId) {
		super();
		
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.doctorPhNo = doctorPhNo;
		this.identifier=identifier;
		this.hospitalId=hospitalId;
	}
	
	public Doctor()
	{
		super();
	}

	/**
	 * @return the doctor name present in the database.
	 */

	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * set the name of the doctor.
	 * @param doctorName
	 */

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	/**
	 * @return the specialization of the doctor.
	 */

	public String getSpecialization() {
		return specialization;
	}
	/**
	 * set the specialization of the doctor.
	 * @param specialization
	 */

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	/**
	 * @return the phone number of the doctor.
	 */

	public long getDoctorPhNo() {
		return doctorPhNo;
	}

	/**
	 * set the phone number of the doctor.
	 * @param doctorPhNo
	 */
	public void setDoctorPhNo(long doctorPhNo) {
		this.doctorPhNo = doctorPhNo;
	}
	

	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", specialization=" + specialization
				+ ", doctorPhNo=" + doctorPhNo +","+"hospitalId"+hospitalId+"]";
	}
	
	
}
