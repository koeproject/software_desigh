package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.share.AppConfig;
import com.example.share.CompanyInfomation;

@SpringBootApplication(scanBasePackages="com.example")
public class Lab4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CompanyInfomation c1 = (CompanyInfomation) context.getBean("company");
		
		c1.setName("ABC");
		c1.setTelephone("09034948484");
		c1.printInfo();
		
		CompanyInfomation c2 = (CompanyInfomation) context.getBean("company");
		c2.printInfo();
		
		System.out.println("hashcode c1: " + c1.hashCode());
		System.out.println("hashcode c2: " + c2.hashCode());
		
	}

}
