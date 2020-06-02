package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CareProvider")
public class CareProvider extends Person{

	@NotBlank
	private String careProviderId;
	private String careProviderType;
	
	public String getCareProviderId() {
		return careProviderId;
	}

	public void setCareProviderId(String careProviderId) {
		this.careProviderId = careProviderId;
	}

	public String getCareProviderType() {
		return careProviderType;
	}

	public void setCareProviderType(String careProviderType) {
		this.careProviderType = careProviderType;
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
	
}
