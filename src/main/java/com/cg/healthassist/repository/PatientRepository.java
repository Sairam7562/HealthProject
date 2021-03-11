package com.cg.healthassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

	
	Patient findByPatientIdentifier(String patientIdentifier);
}
