package com.cisco.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cisco.entity.Book;
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	 List<Book> findByAuthorName(String author);
	 @Query(nativeQuery = true,value = "select * from books order by price")
		List<Book> findAllBooksSortedByPrice();
		
		@Query("select b from Book b order by b.title desc")
		List<Book> findAllBooksSortedByTitleDesc();

}