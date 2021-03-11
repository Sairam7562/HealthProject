
  package com.cg.healthassist.servicetest;
  
  import static org.junit.jupiter.api.Assertions.*; 
  
  import java.util.Arrays; 
  import java.util.List;
  import org.junit.jupiter.api.BeforeEach; 
  import org.junit.jupiter.api.Test;
  import org.mockito.BDDMockito; 
  import org.mockito.InjectMocks;
  import org.mockito.Mock; 
  import org.mockito.MockitoAnnotations;

import com.cg.healthassist.entity.Doctor;
import com.cg.healthassist.entity.Hospital;
import com.cg.healthassist.entity.Patient;
import com.cg.healthassist.exception.PatientException;
import com.cg.healthassist.repository.DoctorRepository;
import com.cg.healthassist.repository.HospitalRepository;
import com.cg.healthassist.repository.PatientRepository;
import com.cg.healthassist.service.DoctorService;
import com.cg.healthassist.service.HospitalService;
import com.cg.healthassist.service.PatientService;
  
  class PatientServiceTest {
  
  @Mock PatientRepository patientRepository;
  @Mock HospitalRepository hospitalRepository;
  @Mock DoctorRepository doctorRepository;
  @InjectMocks PatientService patientService;
  @InjectMocks DoctorService doctorService;
  @InjectMocks HospitalService hospitalService;
 
  
  
  public static String hospitalAddress="Hyderabad";
  public static List<String> hospitalSpecialities=Arrays.asList("MBBS","ENT");
  public static boolean beds=true;
  public static String hospitalName="omega";
  public static String identifier="12345";
  public static String doctorName="Niklaus";
  public static String specialization="MBBS";
  public static String phoneNumber="123456789"; 
  public static String patientName="elizha";
  public static String patientAge="24";
  public static String patientAddress="Chennai";
  public static String prescription="cipla";
  
  @SuppressWarnings("deprecation")
@BeforeEach public void setup() 
  { 
	  MockitoAnnotations.initMocks(this); 
}
  
  
 
  
  @Test 
  void test1_saveOrUpdate() 
  { 
	  Patient patient = new Patient(identifier,patientName,patientAge,phoneNumber,patientAddress);
	  BDDMockito.given(patientRepository.save(patient)).willReturn(patient);
	  Patient p = patientService.saveOrUpdate(patient); assertNotNull(p);
	  assertEquals(patientName,p.getPatientName());
	  assertEquals(identifier,p.getPatientIdentifier());
	  assertEquals(patientAge,p.getPatientAge());
	  assertEquals(phoneNumber,p.getPhoneNumber());
	  assertEquals(patientAddress,p.getPatientAddress());
  
  } 
  
  
  @Test 
  void test2_saveOrUpdate_ThrowPatientException() 
  { 
	  Patient patient = new Patient(identifier,patientName,patientAge,phoneNumber,patientAddress);
	  BDDMockito.given(patientRepository.save(patient)).willThrow(new PatientException());
	  assertThrows(PatientException.class,()->patientService.saveOrUpdate(patient)); 
  }
 /**
	 * This test method tests findPatientByPatientIdentifier method
	 */

  
  @Test 
  void test3_findPatientByPatientIdentifier() 
  {
	  BDDMockito.given(patientRepository.findByPatientIdentifier(identifier)).willReturn((new Patient(identifier,patientName,patientAge,phoneNumber,patientAddress))); 
	  Patient patient=patientService.findPatientByPatientIdentifier(identifier);
	  assertNotNull(patient); 
	  assertEquals(patientName, patient.getPatientName());
	  assertEquals(patientAge, patient.getPatientAge());
	  assertEquals(phoneNumber,patient.getPhoneNumber());
	  assertEquals(patientAddress,patient.getPatientAddress());
  
  }
 /**
	 * This test method tests findPatientByPatientIdentifier method when it throws
	 * exception
	 */

  
  
  @Test 
  void test4_findPatientByPatientIDentifier() 
  {
	  BDDMockito.given(patientRepository.findByPatientIdentifier(identifier)).willThrow(new PatientException());
	  assertThrows(PatientException.class,()->patientService.findPatientByPatientIdentifier(identifier)); 
	}
  }
 /**
	 * This test method tests searchHospitalByDoctorAvailability
	 */

 
 
 
  
 