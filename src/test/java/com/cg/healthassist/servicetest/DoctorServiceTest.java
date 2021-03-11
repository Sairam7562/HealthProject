package com.cg.healthassist.servicetest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.healthassist.entity.Doctor;
import com.cg.healthassist.exception.DoctorException;
import com.cg.healthassist.repository.DoctorRepository;
import com.cg.healthassist.repository.HospitalRepository;
import com.cg.healthassist.repository.PatientRepository;
import com.cg.healthassist.service.DoctorService;
import com.cg.healthassist.service.HospitalService;
import com.cg.healthassist.service.PatientService;


class DoctorServiceTest {
	
	@Mock PatientRepository patientRepository;
	@Mock HospitalRepository hospitalRepository;
	@Mock DoctorRepository doctorRepository;
	@InjectMocks PatientService patientService;
	@InjectMocks DoctorService doctorService;
	@InjectMocks HospitalService hospitalService;


	
	public static String identifier="12345";
	public static String doctorName="Niklaus";
	public static String specialization="MBBS";
	public static Long phoneNumber=(long) 123456789; 
	
	 @SuppressWarnings("deprecation")
	 @BeforeEach public void setup() 
	   { 
	 	  MockitoAnnotations.initMocks(this); 
	 }
	 
	 
	 @Test
	 void test1_saveOrUpdate()
	 {
		Doctor doctor = new Doctor(doctorName,specialization,phoneNumber,identifier,identifier);
		  BDDMockito.given(doctorRepository.save(doctor)).willReturn(doctor);
		  Doctor d = doctorService.saveOrUpdate(doctor); assertNotNull(d);
		  assertEquals(doctorName,d.getDoctorName());
		  assertEquals(identifier,d.getIdentifier());
		  assertEquals(phoneNumber,d.getDoctorPhNo());
	 }
	 
	 
	 
	 @Test
		void test2_findDoctor() {
		 	Doctor doctor = new Doctor(doctorName,specialization,phoneNumber,identifier,identifier);
			when(doctorRepository.findByIdentifier(identifier)).thenReturn(doctor);
			assertNotNull(doctor);
			assertEquals(doctorName,doctor.getDoctorName());
			assertEquals(specialization,doctor.getSpecialization());
			assertEquals(phoneNumber,doctor.getDoctorPhNo());
			
		}
		
		
		@Test
		void test3_findDoctor_ThrowException()
		{
			BDDMockito.given(doctorRepository.findByIdentifier(identifier)).willThrow(new DoctorException());
			assertThrows(DoctorException.class, ()->doctorService.findDoctorByDoctorIdentifier(identifier));
		}
		
		
		@Test
		void test4_getAlldoctorsAvailability() {
			
			Doctor doctor = new Doctor(doctorName,specialization,phoneNumber,identifier,identifier);
			  when(doctorService.allDoctors()).thenReturn(List.of(doctor));
			  assertNotNull(doctor);
			  assertEquals(doctorName,doctor.getDoctorName());
			  assertEquals(specialization,doctor.getSpecialization());
			  assertEquals(phoneNumber,doctor.getDoctorPhNo());
			 
			
		}
}
