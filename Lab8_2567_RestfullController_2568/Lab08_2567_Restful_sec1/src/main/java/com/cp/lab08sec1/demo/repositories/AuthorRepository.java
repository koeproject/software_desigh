package com.cp.lab08sec1.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cp.lab08sec1.demo.model.Author;

@Repository
public interface AuthorRepository  extends 
        CrudRepository<Author, Long>{

}
// long primitive data type, Long is a Long class
