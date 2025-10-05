package com.customer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRequest {
	@NotBlank(message = "customer Name must not be blank")
	@Size(max = 200,message = "customerName must be at most 200 characters")
	private String name;
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Email must be valid")
	@Size(max = 200,message = "email must be at most 254 characters")
	private String email;
	public CustomerRequest() {}
	public CustomerRequest(String name,String email) {
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
