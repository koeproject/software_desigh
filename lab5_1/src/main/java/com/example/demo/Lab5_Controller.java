package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lab5_Controller {
	
	@GetMapping("/hello")
	public String greteing(Model model) {
		model.addAttribute("name","koeey");
		return "hello";
	}
	
}
