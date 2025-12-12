package com.cisco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.entity.Book;
import com.cisco.exception.AuthorNotFoundException;
import com.cisco.exception.BookNotFoundException;
import com.cisco.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
@Autowired
BookRepository repo;

	@Override
	public Book addBook(Book book) {
		
		return repo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return repo.findAll();
	}

	@Override
	public Book getBookById(int id) {
			
   return repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book with id "+id+" not found "));
	}
	@Override
	public String deleteBookById(int id) {
		
    Book b=getBookById(id);
    if(b==null) {
	throw new BookNotFoundException ("Book with id "+id+" not found ");
    }else {
	repo.deleteById(id);
	return  "book deleted";
	
}	
	}

	@Override
	public Book updateBookById(int id, Book b) {
		Book c=getBookById(id);
		if(c==null) {
			throw new BookNotFoundException ("Book with id "+id+" not found ");
		    }else {
		c.setAuthorName(b.getAuthorName());
		
		c.setPrice(b.getPrice());
		repo.save(c);
		return c;
	}
	}

	@Override
	public List<Book> findByAuthorName(String author) {
		if(repo.findByAuthorName(author).isEmpty())
			throw new AuthorNotFoundException("Author with name "+author+" not found ");
		return repo.findByAuthorName(author);
	}

	@Override
	public List<Book> findAllBooksSortedByPrice() {
		// TODO Auto-generated method stub
		return repo.findAllBooksSortedByPrice();
	}

	@Override
	public List<Book> findAllBooksSortedByTitleDesc() {
		// TODO Auto-generated method stub
		return repo.findAllBooksSortedByTitleDesc();
	}

}
