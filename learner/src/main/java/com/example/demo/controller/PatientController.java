package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.PatientRepository;
import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Patient;

@RestController
@RequestMapping("/")
public class PatientController {
	
	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/patients")
	public List<Patient> getAllPateints() {
		return patientRepository.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable(value="id") Long patientId) {
		
		return patientRepository.findById(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("patient", "id", patientId));
	}
	
	@PostMapping("/patients")
	public Patient createPatient(@Valid @RequestBody Patient patient) {
		return patientRepository.save(patient);
	}
	
	@PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable(value = "id") Long patientId,
                                           @Valid @RequestBody Patient patientDetails) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));

        patient.setName(patientDetails.getName());
        patient.setContactNo(patientDetails.getContactNo());
        patient.setAddress(patientDetails.getAddress());
        patient.setUuid(patientDetails.getUuid());
        patient.setBill(patientDetails.getBill());
        
        Patient updatedPatient = patientRepository.save(patient);
        return updatedPatient;
    }
	
	@DeleteMapping("/patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable(value = "id") Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));

        patientRepository.delete(patient);

        return ResponseEntity.ok().build();
	}
}

