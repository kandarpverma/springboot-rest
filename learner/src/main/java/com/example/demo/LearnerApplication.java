package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Bill;
import com.example.demo.model.Patient;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.PatientRepository;



@SpringBootApplication
public class LearnerApplication {
	
	private static PatientRepository pat;
	private static BillRepository bil;

	public static void main(String[] args) {
		SpringApplication.run(LearnerApplication.class, args);
//		ConfigurableApplicationContext context =  SpringApplication.run(LearnerApplication.class, args);
//		
//		Patient p = context.getBean(Patient.class);
//		Bill b = context.getBean(Bill.class);
//		
//		p.setAddress("delhi");
//		p.setAge(19);
//		p.setContactNo("123");
//		p.setName("kandarp");
//		p.setUuid("id001");
//		
//		b.setBilledAmount(1200);
//		b.setBillId("bill001");
//		b.setPaymentType(1);
//		b.setServiceType(2);
//		
//		p.setBill(b);
//		b.setPatient(p);
//		
//		pat.save(p);
//		bil.save(b);
	}

}
