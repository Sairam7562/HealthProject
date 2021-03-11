package com.cg.healthassist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.entity.Hospital;
import com.cg.healthassist.service.HospitalService;
@RestController
@RequestMapping("/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@PostMapping("/newHospital")
	public ResponseEntity<Hospital> createNewHospital(@RequestBody Hospital hosp) {
		Hospital newHospital = hospitalService.saveOrUpdate(hosp);
		return new ResponseEntity<>(newHospital, HttpStatus.CREATED);
	}
	}

