package com.cg.healthassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.entity.PatientLogin;
@Repository
public interface PatientLoginRepository extends JpaRepository<PatientLogin,Long>{
		PatientLogin findByPatientIdentifier(String patientIdentifier);
}
