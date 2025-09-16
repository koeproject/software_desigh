package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.User;

@Configuration 
public class AppConfig {
	@Bean
	public User user() {
		// return Bean object, spring in Ioc container 
		return new User("koeey", 21);
	}
}
