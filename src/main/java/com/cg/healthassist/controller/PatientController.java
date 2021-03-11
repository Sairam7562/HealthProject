package com.cg.healthassist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.entity.Hospital;
import com.cg.healthassist.entity.Patient;
import com.cg.healthassist.repository.PatientRepository;
import com.cg.healthassist.service.PatientService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@PostMapping("/newPatient")
	public ResponseEntity<Patient> createNewPatient(@RequestBody Patient patient) {

		Patient newPatient = patientService.saveOrUpdate(patient);
		return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Patient> getAllEmployees(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/{patientIdentifier}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value="patientIdentifier") String patientIdentifier) {
		return new ResponseEntity<>(patientService.findPatientByPatientIdentifier(patientIdentifier),HttpStatus.OK);
	}
	//@RequestMapping(value = "/searchHospitalByBed", method = RequestMethod.POST)
	@GetMapping("/searchHospitalByBed")
	public ResponseEntity<String> searchByBed() {
		String hospitalList = patientService.searchHospitalByBedAvailability();
		if (hospitalList.isEmpty()) {
			return new ResponseEntity<>("Hospital has no beds available", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(hospitalList+" hospitals has beds available", HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/delete/{patientIdentifier}")
	public ResponseEntity<String> deletePatientById(@PathVariable(value="patientIdentifier") String patientIdentifier) {
		Patient patient=patientService.findPatientByPatientIdentifier(patientIdentifier);
		patientRepository.delete(patient);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}

	 

	@GetMapping("/Speciality/{speacility}")
	public ResponseEntity<String> hospitalBySpeciality(@PathVariable(value="speacility") String hospitalSpeciality) {
		Hospital hospital = patientService.searchHospitalBySpeciality(hospitalSpeciality);
		if (hospital != null) {
			return new ResponseEntity<>(hospitalSpeciality + " Speciality is available in the hospital",HttpStatus.OK);
		} 
		else 
		{
			return new ResponseEntity<>(hospitalSpeciality + " Speciality is not available in the hospital",HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	@GetMapping(value = "/doctorAvailability/{identifier}")
	  public ResponseEntity<String> doctorAvailability(@PathVariable(value="identifier") String name) {
	  
	  Hospital hospital =patientService.searchHospitalByDoctorAvailability(name); 
	  if (hospital!= null)
	  { 
		  return new ResponseEntity<>(hospital.getHospitalName(), HttpStatus.OK); 
	  } 
	  else 
	  { 
		  return new ResponseEntity<>(" Doctor is not available in any hospital ", HttpStatus.BAD_REQUEST); }
	  
	  }

		  @GetMapping("/bookBed/{hospitalIdentifier}")
		  public ResponseEntity<String> bookBed(@PathVariable(value="hospitalIdentifier") String identifier ){
		
		  if(patientService.bookBed(identifier))
		  { 
			  return new ResponseEntity<>("Bed Successfully Booked!!",HttpStatus.OK);
		  }
		  else
		  { 
			  return new ResponseEntity<>("Beds are filled! Cannot Book Bed ",HttpStatus.BAD_REQUEST); 
		  }
		 
		  
		  }
		  
		 
}