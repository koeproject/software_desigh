package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;


@Configuration
//@ComponentScan("com.example.model")
public class AppConfig {
	
	@Bean("user1")
	public User user1() {
		return new User("koeey",23);
	}
	
	@Bean("user2")
	public User user2() {
		return new User("Lisa",34);
	}
}
