package com.customer.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerRequest;
import com.customer.repo.CustomerResponse;
import com.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController 
@RequestMapping("/api/customers")
public class CustomerController {
	private final CustomerService service;
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse create(@RequestBody @Valid CustomerRequest req) {
		return service.create(req);
	}
	
	@GetMapping("/{id}")
	public CustomerResponse get(@PathVariable Long id) {
		return service.get(id);
	}

}
