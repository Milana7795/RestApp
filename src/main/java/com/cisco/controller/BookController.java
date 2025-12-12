package com.cisco.controller;

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

import com.cisco.entity.Book;

import com.cisco.exception.AuthorNotFoundException;
import com.cisco.exception.BookNotFoundException;
//import com.cisco.exception.UserNotFoundException;
import com.cisco.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService service;
	
	@PostMapping
	 ResponseEntity<Book> addBook(@RequestBody Book book) {
	return ResponseEntity.status(HttpStatus.CREATED).body(service.addBook(book));
	}
	
	@GetMapping
	 ResponseEntity<List<Book>> getAllBooks(){
	System.out.println("************Restdemo project updated***************************");
		return ResponseEntity.ok(service.getAllBooks());
	}
	
	@GetMapping("/{id}") 
	ResponseEntity<?> getBookById(@PathVariable int id) {
		try {
		Book book= service.getBookById(id);
		
			return ResponseEntity.ok(book);
		}
		catch(BookNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
			
		}
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteBookById(@PathVariable("id") int id) {
	try {
		String msg=service.deleteBookById(id);
		
			return ResponseEntity.ok(msg);
		
		}catch(BookNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}
	}
	
	
	@PutMapping("/{id}") 
	      ResponseEntity<?> updateBookById(@PathVariable int id, @RequestBody  Book b) {
		try {
			return ResponseEntity.ok(service.updateBookById(id,b));
			
		}catch(BookNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());	
		}
		//return service.updateBookById(id,b);
	}
	
	@GetMapping("/author/{author}")
	   ResponseEntity<?> findByAuthorName(@PathVariable("author")  String author){
		try {
			return ResponseEntity.ok(service.findByAuthorName(author));
			
		}catch(AuthorNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
		}	
		//return service.findByAuthorName(author);
	}
	
	@GetMapping("/order/price")
	ResponseEntity<List<Book>> findAllBooksSortedByPrice(){
		return  ResponseEntity.ok(service.findAllBooksSortedByPrice());
		
	}
	
	@GetMapping("/order/title/desc")
	ResponseEntity<List<Book>> findAllBooksSortedByTitleDesc(){
		return  ResponseEntity.ok(service.findAllBooksSortedByTitleDesc());
		
	}
	
	
	

}
