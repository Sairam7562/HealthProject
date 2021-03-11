package com.cg.healthassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> 
{
	Doctor findByIdentifier(String doctorIdentifier);
}
