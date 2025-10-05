package com.customer.dto;

import com.customer.model.Customer;

public class CustomerResponse {
	private Long id;
	private String name;
	private String email;
	public CustomerResponse(Long id,String name,String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public static CustomerResponse fromEntity(Customer c) {
		return new CustomerResponse(c.getId(),c.getName(),c.getEmail());
	}

}
