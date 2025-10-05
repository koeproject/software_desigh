package com.customer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=100)
	private String name;
	
	@Email
	@Size(max=120)
	@Column(unique = true)
	private String email;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private Address address;
	
	public void setAddress(Address address) {
		if(address == null) {
			if(this.address != null) this.address.setCustomer(null);
			this.address = null;
		}else {
			address.setCustomer(this);
			this.address = address;
		}
	}
	
	//getter setter 
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Address getAddress() {
		return address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
