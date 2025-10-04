package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration
public class AppConfig {
	@Bean(name = "user") 
	public User user1() { //bean id = "user"
		return new User("Lisa",25); //io container
	}
}
