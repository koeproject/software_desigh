package com.cp.kku.demo.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatusCode;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import com.cp.kku.kku.demo.model.Author;
import reactor.core.publisher.Flux;


@Service
public class WebClientAuthorService {
	@Autowired
	 private final WebClient webClient;
	 @Autowired
	 public WebClientAuthorService(WebClient webClient) {
	        this.webClient = webClient;
	 }
	 //get request
	 public Flux<Author> getAllAuthors() {// List<Author>
	        return webClient.get()
	                .uri("/authors") 
	                .retrieve()
	                .bodyToFlux(Author.class) ;
	    }
	 public Mono<Author> getAuthorById(Long id) {
	        return webClient.get()
	                .uri("/authors/{id}", id)
	                .retrieve()
	                .bodyToMono(Author.class);
	    }
	 public Mono<Author> createAuthor(Author author) {
		    System.out.println("Sending Author: " + author);

		    return webClient.post()
		            .uri("/authors")
		            .body(Mono.just(author), Author.class)
		            .retrieve()
		            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> 
		                Mono.error(
		                		new RuntimeException("Client error during createAuthor")))
		            .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> 
		                Mono.error(new RuntimeException("Server error during createAuthor")))
		            .bodyToMono(Author.class)
		            .doOnNext(response ->
		                  System.out.println("Response received: " + response))
		            .doOnError(error ->
		                   System.out.println("Error occurred: " + error.getMessage()));
		}


	    public Mono<Author> updateAuthor(Long id, Author author) {
	    	System.out.println("Edited Author "+ author.toString());
	        return webClient.put().uri("/authors/"+id)
	        		.bodyValue(author).retrieve().bodyToMono(Author.class);
	    }

	   
	    public Mono<Void> deleteAuthorById(Long id) {
	    	//System.out.println("deleting an author having id ="+id);
	        return webClient.delete()
	                .uri("/authors/{id}", id)
	                .retrieve()
	                .bodyToMono(Void.class);
	    }
}
