package com.cg.healthassist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthassist.entity.PatientLogin;
import com.cg.healthassist.exception.PatientException;
import com.cg.healthassist.repository.PatientLoginRepository;



@Service
public class LoginService {
	@Autowired
	PatientLoginRepository patientLoginRepository;
	String msg="PatientUsername ";
public PatientLogin saveOrUpdate(PatientLogin patientLogin) {
		
		try {
			patientLogin.setPatientIdentifier(patientLogin.getPatientIdentifier().toUpperCase());
			return patientLoginRepository.save(patientLogin);
		} catch (Exception e) {
			throw new PatientException( msg+ patientLogin.getPatientIdentifier() + " already available");
		}

	}

	public PatientLogin findLoginByPatientIdentifier(String patientIdentifier) {
		PatientLogin patientLogin = patientLoginRepository.findByPatientIdentifier(patientIdentifier.toUpperCase());
		if (patientLogin == null) {
			throw new PatientException(msg+ patientIdentifier + " not available");
			
		}
		return patientLogin;

	}
	public void deletePatientByPatientIdentifier(String patientIdentifier) {
		PatientLogin patientLogin=findLoginByPatientIdentifier(patientIdentifier.toUpperCase());
		if(patientLogin==null) {
			throw new PatientException(msg+ patientIdentifier + " not available");
		}
		patientLoginRepository.delete(patientLogin);
	}
	public String validatePatientLogin(String patientIdentifier,String password)
	{
		String result="";
		PatientLogin patientLogin=patientLoginRepository.findByPatientIdentifier(patientIdentifier);
		if(patientLogin==null || !(patientLogin.getPatientIdentifier().equals(patientIdentifier)))
		{
			result="Username does not exist";
		}
		else if(patientLogin.getPatientIdentifier().equals(patientIdentifier) && patientLogin.getPassword().equals(password))
		{
			result="Login Successful";
		}
		else if(patientLogin.getPatientIdentifier().equals(patientIdentifier) && !(patientLogin.getPassword().equals(password)))
		{
			result="Username and password does not match";
		}
		
		return result;
	}
}
