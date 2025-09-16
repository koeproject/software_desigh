package com.example.model;

public class User {
	private String name;
	private int age;
	
	public User() {
		// Default constructor
	}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void display() {
		System.out.println("name : " + name + "age : " + age);
	}
	

}
