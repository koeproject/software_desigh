package com.customer.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.customer.dto.CustomerRequest;
import com.customer.dto.CustomerResponse;
import com.customer.model.Customer;
import com.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class RestCustomerController {
	
	private final CustomerService service;
	public RestCustomerController(CustomerService service) {
		this.service = service;
	}
	
	@GetMapping 
	public List<CustomerResponse> getAll(){
		return service.getAll().stream().map(CustomerResponse::fromEntity).toList();
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest req,UriComponentsBuilder uriBuilder){
		Customer saved = service.create(req.getName(), req.getEmail());
		URI location = uriBuilder.path("/api/customer/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).body(CustomerResponse.fromEntity(saved));
	}
		
	
	@GetMapping("/{id}")
	public CustomerResponse getOne(@PathVariable Long id) {
        return CustomerResponse.fromEntity(service.getById(id));
    }
	
	 @PutMapping("/{id}")
	    public CustomerResponse update(@PathVariable Long id,
	                                   @Valid @RequestBody CustomerRequest req) {
	        return CustomerResponse.fromEntity(service.update(id,req.getName(),req.getEmail()));
	    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	
}
