package com.lab8.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab8.DTO.CustomerRequest;
import com.lab8.DTO.CustomerResponse;
import com.lab8.entity.Customer;
import com.lab8.repository.CustomerRepository;


@Service

public class CustomerService {
	
	@Autowired
	private CustomerRepository repoCust;
	
	private CustomerResponse mapToResponse(Customer cust) {
		return new CustomerResponse(cust.getId(),cust.getName(),cust.getEmail());
	}
	
	private Customer toEntity(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		return customer;
	}
	
	public List<CustomerResponse> getCustomerList(){
		List<Customer> customer = (List<Customer>) repoCust.findAll();
		return customer.stream().map(c->new CustomerResponse(c.getId(),c.getName(),c.getEmail())).toList();
		}
	
	public CustomerResponse getCustomerNyId(long id) {
		Customer customer = repoCust.findById(id).get();
		return mapToResponse(customer);
	}
	
	public void save(CustomerRequest cust) {
		Customer customer = toEntity(cust);
		repoCust.save(customer);
	}
	
	public CustomerResponse addCustomer(CustomerRequest cust) {
		Customer customer = toEntity(cust);
		Customer custNew = repoCust.save(customer);
		return new CustomerResponse(custNew.getId(),custNew.getName(),custNew.getEmail());
	}
	
	public CustomerResponse updateCustomer(long id, CustomerRequest custNew) {
		Customer custE
	}
	
}
