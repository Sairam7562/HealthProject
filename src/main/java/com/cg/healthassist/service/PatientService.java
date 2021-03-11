package com.cg.healthassist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthassist.entity.*;
import com.cg.healthassist.exception.HospitalException;
import com.cg.healthassist.exception.PatientException;
import com.cg.healthassist.repository.DoctorRepository;
import com.cg.healthassist.repository.HospitalRepository;
import com.cg.healthassist.repository.PatientRepository;

import java.util.List;
@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	DoctorRepository doctorRepository; 
	@Autowired
	HospitalRepository hospitalRepository;
	String msg="PatientIdentifier ";
	public PatientRepository getPatientRepository() {
		return patientRepository;
	}	
	
	public Patient saveOrUpdate(Patient patient) {
		
		try {
			patient.setPatientIdentifier(patient.getPatientIdentifier().toUpperCase());
			return patientRepository.save(patient);
		} catch (Exception e) {
			throw new PatientException( msg+ patient.getPatientIdentifier() + " already available or does not exist");
		}

	}

	public Patient findPatientByPatientIdentifier(String patientIdentifier) {
		Patient patient = patientRepository.findByPatientIdentifier(patientIdentifier.toUpperCase());
		if (patient == null) {
			throw new PatientException(msg+ patientIdentifier + " not available");
			
		}
		return patient;

	}
	
	
	
	public void deletePatientByPatientIdentifier(String patientIdentifier) {
		Patient patient=findPatientByPatientIdentifier(patientIdentifier.toUpperCase());
		if(patient==null) {
			throw new PatientException(msg+ patientIdentifier + " not available");
		}
		patientRepository.delete(patient);
	}
	
	
	public String searchHospitalByBedAvailability() {
		List<Hospital> hospitalList=hospitalRepository.findAll();
		StringBuilder name=new StringBuilder();
		for(Hospital obj:hospitalList)
		{
			if((boolean) obj.getBeds())
			{
				name.append(" ,"+obj.getHospitalName());
			}
		}
		return name.toString();
		}
		
	
	public Hospital searchHospitalByDoctorAvailability(String identifier) 
	{
		Doctor doctor=doctorRepository.findByIdentifier(identifier);
		String id=doctor.getHospitalId();
		return hospitalRepository.findByHospitalIdentifier(id);
		 
	}
	
	
	public HospitalRepository getHospitalRepository() {
		return hospitalRepository;
	}

	public void setHospitalRepository(HospitalRepository hospitalRepository) {
		this.hospitalRepository = hospitalRepository;
	}

	public Hospital searchHospitalBySpeciality(String hospitalSpeciality) 
	{
			List<Hospital> hospitalList=hospitalRepository.findAll();
			Hospital availableHospital=null;
			for(Hospital hospital:hospitalList)
			{
				List<String> specialities = hospital.getHospitalSpecialities();
				for(String s:specialities)
				{
					if(s.equalsIgnoreCase(hospitalSpeciality))
					{
						availableHospital=hospital;
						break;
					}
				}
				if(availableHospital!=null)
				{
					break;
				}
			}
			if(availableHospital==null)
			{
				throw new HospitalException("No available Hospital for Required Speciality");
			}
			return availableHospital;
	}
	public boolean bookBed(String hospitalIdentifier)
	{	
		Hospital hospital=hospitalRepository.findByHospitalIdentifier(hospitalIdentifier);
		boolean result=false;
		boolean bed=hospital.getBeds();
		if(bed)
		{
			result=true;
		}
		return result;
		
	}
	
		
}