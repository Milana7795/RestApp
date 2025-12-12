package com.cisco.service;

import java.util.List;

import com.cisco.entity.Book;

public interface BookService {

	Book addBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(int id);
	 String deleteBookById(int id);
	Book updateBookById(int id,Book b);
	List<Book> findByAuthorName(String author);
	List<Book> findAllBooksSortedByPrice();
	List<Book> findAllBooksSortedByTitleDesc();
}
