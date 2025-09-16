package com.lab8.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lab8.entity.*;

public interface CustomerRepository extends CrudRepository<Customer,Long>{


}
