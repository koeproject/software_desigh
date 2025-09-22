package com.lab8.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab8.DTO.CustomerRequest;
import com.lab8.DTO.CustomerResponse;
import com.lab8.entity.Customer;
import com.lab8.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")

public class CustomerRestController {
	@Autowired
	private CustomerService custService;
	
	@GetMapping
	public ResponseEntity<List<CustomerResponse>>getAllCustomer(){
		List <CustomerResponse> customers = custService.getCustomerList();
		return new ResponseEntity<>(customers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id){
		CustomerResponse cust = custService.getCustomerById(id);
		return new ResponseEntity<>(cust,HttpStatus.OK);
	}
	
	@PostMapping
	public CustomerResponse addCustomer(@Valid @RequestBody CustomerRequest cust) {
		CustomerResponse custNew = custService.addCustomer(cust);
		return custNew;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponse> updateCustomerById(@PathVariable Long id,@RequestBody CustomerRequest custReq){
		return new ResponseEntity<>(custService.updateCustomer(id, custReq),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
		CustomerResponse custDel = custService.getCustomerById(id);
		if(custDel != null) {
			custService.deleteCustomerById(id);
			return new ResponseEntity<>("deleted",HttpStatus.OK);
		}
		return new ResponseEntity<>("Customer does not Exist",HttpStatus.NOT_FOUND);
	}
}

