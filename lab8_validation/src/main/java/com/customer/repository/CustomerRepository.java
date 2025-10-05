package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
	boolean existsByEmail(String email);
}
