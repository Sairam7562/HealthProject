package com.cg.healthassist.exception;

@SuppressWarnings("serial")
public class DoctorException extends RuntimeException{
	
	public DoctorException() {
		super();
	}
	
	public DoctorException(String errMessage) {
		super(errMessage);
	}

}
