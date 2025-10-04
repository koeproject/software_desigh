package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Customer;

@Controller
public class Lab5_Controller {
	
	@GetMapping("/customer")
	public String greteing(Model model) {
		
		Customer customer = new Customer(1L,"koeey");
		model.addAttribute("customer",customer);
		return "customer";
	}
	
}
