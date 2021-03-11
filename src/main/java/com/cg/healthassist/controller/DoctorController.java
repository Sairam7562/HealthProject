package com.cg.healthassist.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.entity.Doctor;
import com.cg.healthassist.repository.DoctorRepository;
import com.cg.healthassist.service.DoctorService;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorRepository doctorrepository;
	@Autowired
	private DoctorService doctorService;
	
	
	
	@PostMapping("/newDoctor")
	public ResponseEntity<Doctor> createNewDoctor(@Valid @RequestBody Doctor doctor, BindingResult result)
	{
		
		Doctor newDoctor = doctorService.saveOrUpdate(doctor);
		return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
	}
	
	@GetMapping("/{identifier}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable(value="identifier") String doctorIdentifier){
		return new ResponseEntity<>( doctorService.findDoctorByDoctorIdentifier(doctorIdentifier),HttpStatus.OK);
	}


}