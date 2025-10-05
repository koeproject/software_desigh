package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.web.DuplicateEmailException;
import com.customer.web.ResourceNotFoundException;



@Service
@Transactional
public class CustomerService {
	private final CustomerRepository repo;
	
	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}
	public Customer create(String name,String email) {
		if(repo.existsByEmail(email)) {
			throw new DuplicateEmailException("email already exists: "+ email);
		}
		return repo.save(new Customer(name,email));
	}
	
	@Transactional(readOnly = true)
	public Customer getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer %d not found".formatted(id)));
	}
	
	@Transactional(readOnly = true)
	public List<Customer> getAll(){
		return repo.findAll();
	}
	
	public Customer update(Long id,String name,String email) {
		Customer c = getById(id);
		c.setName(name);
		if(!c.getEmail().equalsIgnoreCase(email) && repo.existsByEmail(email)) {
			throw new DuplicateEmailException(" Email already exists: "+email);
		}
		c.setName(name);
		c.setEmail(email);
		return repo.save(c);
	}
	
	public void delete(Long id) {
		if(!repo.existsById(id)) {
			throw new ResourceNotFoundException("Customer %d not found".formatted(id));
		}
		repo.deleteById(id);
	}
}
