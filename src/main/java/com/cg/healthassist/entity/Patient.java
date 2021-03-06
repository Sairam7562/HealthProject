package com.cg.healthassist.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	@Column(unique = true,updatable = false)
	@NotBlank(message="Patient Identifier can't be blank")
	@Size(min=4, max=5,message = "Size must be between 4 to 5 characters")
	private String patientIdentifier;
	
	@NotBlank(message="Patient Name is requried")
	private String patientName;
	
	@NotBlank(message="Patient Age is required")
	private String patientAge;
	
	@NotBlank(message="Phone number can't be blank")
	private String phoneNumber;
	
	@NotBlank(message="Patient address can't be blank")
	private String patientAddress;
	
	private String prescription;
	
	public Patient(String patientIdentifier,String patientName,String patientAge,String phoneNumber,String patientAddress) {
		super();
		this.patientIdentifier = patientIdentifier;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.phoneNumber = phoneNumber;
		this.patientAddress = patientAddress;
	}

	
	public Patient() {
		super();
	}

	/**
	 * @return the patient id present in the database.
	 */
	public long getPatientId() {
		return patientId;
	}
	
	/**
	 * Set the id of the patient.
	 * @param patientId
	 */
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	/**
	 * @return the patient name.
	 */
	public String getPatientName() {
		return patientName;
	}
	
	/**
	 * Set the name of the patient.
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	/**
	 * @return the age of the patient.
	 */
	public String getPatientAge() {
		return patientAge;
	}
	
	/**
	 * Set the age of the patient.
	 * @param patientAge
	 */
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	
	/**
	 * @return the phone number of the patient.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set the phone number of the patient.
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the address of the patient.
	 */
	public String getPatientAddress() {
		return patientAddress;
	}
	
	/**
	 * set the address of the patient.
	 * @param patientAddress
	 */
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	
	/**
	 * @return the prescription of the patient.
	 */
	public String getPrescription() {
		return prescription;
	}
	
	/**
	 * Set the prescription of the patient.
	 * @param prescription
	 */
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	/**
	 * @return the patient identifier.
	 */
	public String getPatientIdentifier() {
		return patientIdentifier;
	}

	/**
	 * Set the patient identifier.
	 * @param patientIdentifier
	 */
	public void setPatientIdentifier(String patientIdentifier) {
		this.patientIdentifier = patientIdentifier;
	}
	

	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", patientAge=" + patientAge + ", phoneNumber=" + phoneNumber
				+ ", patientAddress=" + patientAddress + ", prescription=" + prescription + ", patientIdentifier="
				+ patientIdentifier + "]";
	}
	
	
	
}