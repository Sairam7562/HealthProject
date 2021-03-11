package com.cg.healthassist.exception;

@SuppressWarnings("serial")
public class PatientException extends RuntimeException{
	
	public PatientException() {
		super();
	}
	
	public PatientException(String errMessage) {
		super(errMessage);
	}

}
