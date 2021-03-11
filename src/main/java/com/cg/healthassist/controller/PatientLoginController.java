package com.cg.healthassist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.entity.PatientLogin;
import com.cg.healthassist.repository.PatientLoginRepository;
import com.cg.healthassist.service.LoginService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patientLogin")
public class PatientLoginController {
	@Autowired
	private LoginService loginService;
	@PostMapping("/newPatientLogin")
	public ResponseEntity<PatientLogin> createNewPatientLogin(@RequestBody PatientLogin patientLogin) {

		PatientLogin newPatientLogin = loginService.saveOrUpdate(patientLogin);
		return new ResponseEntity<>(newPatientLogin, HttpStatus.CREATED);
	}
	@GetMapping("/{patientIdentifier}")
	public ResponseEntity<PatientLogin> getPatientLoginById(@PathVariable(value="patientIdentifier") String patientIdentifier) {
		return new ResponseEntity<>(loginService.findLoginByPatientIdentifier(patientIdentifier),HttpStatus.OK);
	}
	@GetMapping("/{patientIdentifier}/{password}")
	public ResponseEntity<String> validateLogin(@PathVariable(value="patientIdentifier")String patientIdentifier,@PathVariable(value="password")String password) {
		
		return new ResponseEntity<>(loginService.validatePatientLogin(patientIdentifier, password),HttpStatus.OK);
	}

}
