package com.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="customer",uniqueConstraints = { @UniqueConstraint(name = "uk_customer_email", columnNames = "email") })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(nullable = false ,length = 200)
	private String name;

	@Column(nullable = false ,unique = true,length = 254)
	private String email;
	
	public Customer() {}
	
	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("customerName")
	public void setName(String name) {
		this.name = name;
	}


	
}
