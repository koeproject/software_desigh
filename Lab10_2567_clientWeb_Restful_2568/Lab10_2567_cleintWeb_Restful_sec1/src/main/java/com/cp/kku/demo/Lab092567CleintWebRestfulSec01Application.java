package com.cp.kku.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.cp.kku.demo")
public class Lab092567CleintWebRestfulSec01Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab092567CleintWebRestfulSec01Application.class, args);
		System.out.println("Spring framework version:"+SpringVersion.getVersion());
		System.out.println("Spring boot version:"+SpringBootVersion.getVersion());
	}

}
