package com.cp.lab08sec1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.lab08sec1.demo.repositories.AuthorService;

import com.cp.lab08sec1.demo.model.*;
@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
  @Autowired
  AuthorService authorService;
  @GetMapping
  public ResponseEntity<List<Author>> getAuthors(){
	  List<Author> authors = authorService.getAuthors();
	  return new ResponseEntity<>(authors, HttpStatus.OK);
  }
  
  @GetMapping("/{id}")  //http://localhost:8085/api/authors/1
  public ResponseEntity<Author> getAuthorById(@PathVariable("id")
  Long Id){
	  Author author = authorService.getAuthorById(Id);
	  return new ResponseEntity<>(author,HttpStatus.OK);
  }
  //Post to add a new author  http://localhost:8085/api/authors/?author=
  @PostMapping
  public Author addNewAuthor(@RequestBody Author author) {
	  System.out.println(author);
	 
	  Author savedAuthor = authorService.addAuthor(author);
	  return savedAuthor;
  }
  
  @PutMapping("/{id}") //update http://localhost:8085/api/authors/1?author=
  ResponseEntity<Author> updateAuthor(@RequestBody Author newAuthor, 
		  @PathVariable Long id) {
	  
     Author updateAuthor = authorService.updateAuthorr(id, newAuthor);
     return ResponseEntity.ok(updateAuthor);
  }

  @DeleteMapping("/{id}") // http://localhost:8085/api/authors/1
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("Author deleted successfully");
    }
}
