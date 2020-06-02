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

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Bill;
import com.example.demo.model.Patient;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.PatientRepository;

@RestController
@RequestMapping("/")
public class BillController {
	
	@Autowired
	BillRepository billRepository;
	@Autowired
	PatientRepository patientRepository;
	
	@GetMapping("/bills")
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}
	
	@GetMapping("/bills/{id}")
	public Bill getBillById(@PathVariable(value="id") Long billId) {
		
		return billRepository.findById(billId)
				.orElseThrow(()-> new ResourceNotFoundException("bill", "id", billId));
	}
	
	@PostMapping("/{patientId}/bills")
	public Bill createBill(@PathVariable(value = "patientId") Long patientId, 
												@Valid @RequestBody Bill bill) {
		
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("patient", "id", patientId));
		
		bill.setPatient(patient);
		return billRepository.save(bill);
	}
	
	@PutMapping("/bills/{id}")
    public Bill updatePatient(@PathVariable(value = "id") Long billId,
                                           		@Valid @RequestBody Bill billDetails) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("bill", "id", billId));

        bill.setBillId(billDetails.getBillId());
        bill.setBilledAmount(billDetails.getBilledAmount());
        bill.setPaymentType(billDetails.getPaymentType());
        bill.setServiceType(billDetails.getServiceType());
        bill.setPatient(billDetails.getPatient());
        
        Bill updatedBill = billRepository.save(bill);
        return updatedBill;
    }
	
	@DeleteMapping("/bills/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable(value = "id") Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new ResourceNotFoundException("patient", "id", billId));

        billRepository.delete(bill);

        return ResponseEntity.ok().build();
	}
	
}
