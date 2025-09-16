package com.lab8.service;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(long id) {
		super("could not found" + id);
	}

}
