package com.cp.kku.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;





@Configuration
public class WebAuthorConfig {
	 
	@Bean //bean id ="webclient"
    public WebClient webClient(WebClient.Builder builder) {
    
		return builder.baseUrl("http://localhost:8085/api")
			          .build(); //ioc
    }
	
}

//  //return builder.baseUrl("https://jsonplaceholder.typicode.com")
//RESTful api url="http://localhost:8085/api"
