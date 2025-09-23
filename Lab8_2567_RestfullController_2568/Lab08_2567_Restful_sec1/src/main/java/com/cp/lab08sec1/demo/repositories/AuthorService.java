package com.cp.lab08sec1.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.lab08sec1.demo.model.Author;


@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepo;
	
	public List<Author> getAuthors(){
		List<Author> authors = (List<Author>) authorRepo.findAll();
		return authors;
	}
	public  Author  getAuthorById(Long id){
		return authorRepo.findById(id).orElseThrow(()->
		new AuthorNotFoundException(id));
	}	 
	public void save(Author c) {		
		authorRepo.save(c);
	}
	public Author addAuthor(Author c) {
		authorRepo.save(c);
		return c;
	}
	public void deleteById(Long id) {
		Author author=authorRepo.findById(id).orElseThrow(()->
		new AuthorNotFoundException(id));
		
		//authorRepo.deleteById(id);
		authorRepo.delete(author);
		
	}
	public Author updateAuthorr(Long id, Author c) {
		Author existingAuthor = authorRepo.findById(id).get();
		existingAuthor.setName(c.getName());
		existingAuthor.setEmail(c.getEmail());		
	    return authorRepo.save(existingAuthor);
	}
}
