package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Customer;

@Controller
public class Lab5_Controller {
	
	@GetMapping("/customer")
//	public String greteing(Model model) {
//		
//		Customer customer = new Customer(1L,"koeey");
//		
//		model.addAttribute("customer",customer);
//		return "customer";
//	}
	public List<Customer> greeting(Model model){
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L,"koeey"));
		customers.add(new Customer(2L,"koli"));
		customers.add(new Customer(3L,"kaliyounai"));
		model.addAttribute("customers", customers);

		return customers;
		
	}
	
}
