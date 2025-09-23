package com.cp.kku.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cp.kku.demo.service.WebClientAuthorService;
import com.cp.kku.kku.demo.model.Author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class AuthorController {
	@Autowired
	WebClientAuthorService authorService;

	@GetMapping("/")
	public String getIndex() {
		return "index";
	}

	@GetMapping("/web/authors")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors",
				authorService.getAllAuthors()
				.collectList().block()); // Flux<Author>.block() -> List<Author>																					// // types
		return "authorListCRUD";
	}

	@GetMapping("/web/authors/{id}") // view
	public String getViewAuthorById(@PathVariable Long id, Model model) {
		Author author = authorService.getAuthorById(id).block(); //Mon<Author>.block()->Author
		model.addAttribute("author", author);
		return "authorDetail";
	}

	@GetMapping("/web/createauthor") // Enter a new Author
	public String createAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "addAuthorForm";
	}

	@PostMapping("/web/addAuthor") // save the inputed new author
	public String addAuthor(@ModelAttribute Author authorRequest, 
			Model model) {
		System.out.println("add a new author");
		// ต้องมีตัวแปรมารับ Mono<Author> ก่อน
		Mono<Author> monoAuthor = authorService.createAuthor(authorRequest);
		// ต้องเพิ่ม model ด้วยหลังจากสร้าง new Author ใหม่ เพราะถ้าไม่สร้างจะไม่แสดงใน
		// "authorListCRUD"

		model.addAttribute("author", monoAuthor.block());
		return "redirect:/web/authors";
	}

	@GetMapping("/web/editauthor/{id}") // editing a specific author by id
	public String editAuthor(@PathVariable Long id, Model model) {
		Mono<Author> monoAuthor = authorService.getAuthorById(id);
		Author authorRequest = monoAuthor.blockOptional().get();
		model.addAttribute("author", authorRequest);
		return "editAuthorForm";
	}

	@PostMapping("/web/updateauthor/{id}") // Edit, save the edited author
	public String updateAuthor(@PathVariable Long id,
			@ModelAttribute Author authorRequest, Model model) {

		Mono<Author> monoAuthor = authorService.updateAuthor(id,
											authorRequest);
		model.addAttribute("author", monoAuthor.block());
		return "redirect:/web/authors";
	}

	@GetMapping("/web/deleteauthor/{id}") // delete
	public String deleteAuthor(@PathVariable Long id) {
		// การลบ ควรหาตัวมารับ เพราะใน Service มีสองแบบ คือตัวเดี่ยว ๆ ใช้ Mono
		// ถ้าเป็นกลุ่มใช้ Flux การแปลง จาก Mono เป็น instance ของคลาสใด ๆ ใช้ block()	
		 authorService.deleteAuthorById(id).block();
      //  model.addAttribute("author",monoDeletedAuthor.block());
	    return "redirect:/web/authors";
	  
	}
}
