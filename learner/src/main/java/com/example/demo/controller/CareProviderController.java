package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CareProvider;
import com.example.demo.repository.CareProviderRepository;

@RestController
@RequestMapping("/")
public class CareProviderController {
	
	@Autowired
	CareProviderRepository careProviderRepository;
	
	@GetMapping("/careProviders")
	public List<CareProvider> getAllCareProviders() {
		return careProviderRepository.findAll();
	}
	
	@GetMapping("/careProviders/{id}")
	public CareProvider getCareProviderById(@PathVariable(value="id") Long careProviderId) {
		
		return careProviderRepository.findById(careProviderId)
				.orElseThrow(()-> new ResourceNotFoundException("careProvider", "id", careProviderId));
	}
	
	@PostMapping("/careProviders")
	public CareProvider createCareProvider(@Valid @RequestBody CareProvider careProvider) {
		return careProviderRepository.save(careProvider);
	}
	
	@DeleteMapping("/careProviders/{id}")
    public ResponseEntity<?> deleteCareProvider(@PathVariable(value = "id") Long careProviderId) {
        CareProvider careProvider = careProviderRepository.findById(careProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("careProvider", "id", careProviderId));

        careProviderRepository.delete(careProvider);

        return ResponseEntity.ok().build();
	}
}
