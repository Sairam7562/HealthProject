package com.cg.healthassist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthassist.entity.Doctor;
import com.cg.healthassist.exception.DoctorException;
import com.cg.healthassist.exception.PatientException;
import com.cg.healthassist.repository.DoctorRepository;
@Service
public class DoctorService {
	@Autowired
	DoctorRepository doctorrepository;
	public Doctor saveOrUpdate(Doctor doctor) {

		try {
			doctor.setIdentifier(doctor.getIdentifier().toUpperCase());
			return doctorrepository.save(doctor);
		} catch (Exception e) {
			throw new PatientException("DoctorIdentifier " + doctor.getIdentifier() + " already available");
		}

	}
	public Doctor findDoctorByDoctorIdentifier(String identifier) {
		Doctor doctor = doctorrepository.findByIdentifier(identifier);
		if (doctor == null) {
			throw new DoctorException("DoctorIdentifier " + identifier + " not available");
			
		}
		return doctor;
	}
	
	public boolean bookAnAppoinment(String identifier)
	{
		boolean result=true;
		Doctor doctor = doctorrepository.findByIdentifier(identifier);
		if (doctor == null) {
			result=false;	
		}
		return result;
	}
	public List<Doctor> allDoctors()
	{
		return doctorrepository.findAll();
	}
	
}
