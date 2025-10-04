package com.example.share;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.share")

public class AppConfig {
	
	@Bean("companyinfomation")
	public CompanyInfomation companyinfomation() {
		return new CompanyInfomation();
	}
}
