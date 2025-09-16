package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.User;


@SpringBootApplication
public class Lab03XmlBasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab03XmlBasedApplication.class, args);
		
		try(var context = new ClassPathXmlApplicationContext("applicationContext.xml")){
			User user = (User) context.getBean("user");
			user.display();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
