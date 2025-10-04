package com.example.share;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.example.share")

public class AppConfig {
	
	@Bean("company")
	@Scope("prototype")
	public CompanyInfomation companyinfomation() {
		return new CompanyInfomation();
	}
}
