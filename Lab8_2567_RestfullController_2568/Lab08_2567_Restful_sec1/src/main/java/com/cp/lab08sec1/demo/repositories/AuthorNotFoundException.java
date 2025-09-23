package com.cp.lab08sec1.demo.repositories;

public class AuthorNotFoundException extends RuntimeException {

	 public AuthorNotFoundException (Long id) {
	    super("Could not find author " + id);
	  }

}


 