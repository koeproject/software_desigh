package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.share.AppConfig;
import com.example.share.CompanyInfomation;

@RestController
public class CompanyController {

//	@Autowired
	private CompanyInfomation companyInfomation;

	@GetMapping("/company")
//	@ResponseBody
	public String getCompanyDetials() {
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		companyInfomation = context.getBean(CompanyInfomation.class);
		companyInfomation.setName("Nvidea");
		companyInfomation.setTelephone("64334553456546");
		return "Company: " + companyInfomation.getName() + "Telephone: " + companyInfomation.getTelephone();
	}
}
