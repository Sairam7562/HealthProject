package com.cg.healthassist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthassist.entity.Hospital;
import com.cg.healthassist.exception.HospitalException;
import com.cg.healthassist.exception.PatientException;
import com.cg.healthassist.repository.HospitalRepository;
@Service
public class HospitalService {
	@Autowired
	HospitalRepository hospitalRepository;
	public Hospital saveOrUpdate(Hospital hospital) {

		try {
	
			return hospitalRepository.save(hospital);
			
			 } 
		catch (Exception e) { throw new HospitalException("Hospital " +hospital.getId() + " already available");
		}
		
	}
	public Hospital findHospitalByHospitalIdentifier(String hospitalIdentifier) {
		Hospital hospital = hospitalRepository.findByHospitalIdentifier(hospitalIdentifier.toUpperCase());
		if (hospital == null) {
			throw new PatientException("HospitalIdentifier " + hospitalIdentifier + " not available");
			
		}
		return hospital;

	}
}
