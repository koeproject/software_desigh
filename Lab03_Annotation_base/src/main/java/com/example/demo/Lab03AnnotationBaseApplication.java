package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.User;

@SpringBootApplication
public class Lab03AnnotationBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab03AnnotationBaseApplication.class, args);
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			User user1 = (User) context.getBean("user1");
			user1.display();
			User user2 = (User) context.getBean("user2");
			user2.display();
		}
	}

}
