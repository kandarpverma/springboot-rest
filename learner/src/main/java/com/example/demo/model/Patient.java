package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Patient")
public class Patient extends Person {
	
	@NotBlank
	private String uuid;
	
	@OneToMany(fetch= FetchType.LAZY,  
			cascade = CascadeType.ALL, 
			mappedBy = "patient")
	private Set<Bill> bill;

	public Set<Bill> getBill() {
		return bill;
	}
	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}
	
	@Override
	public Long getId() {
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	@Override
	public int getAge() {
		return super.getAge();
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
	}
	
	@Override
	public String getContactNo() {
		return super.getContactNo();
	}
	
	@Override
	public void setContactNo(String contactNo) {
		super.setContactNo(contactNo);
	}
	
	@Override
	public String getAddress() {
		return super.getAddress();
	}
	
	@Override
	public void setAddress(String address) {
		super.setAddress(address);
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
