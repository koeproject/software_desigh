package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.model.User;

@SpringBootApplication
public class Lab03BasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab03BasedApplication.class, args);
		try(var context = new AnnotationConfigApplicationContext(AppConfig.class)){
			User user = (User) (context).getBean("user");
			user.display();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
