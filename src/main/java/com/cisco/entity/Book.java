package com.cisco.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "book_id")
int bookId;
String title;
@Column(name = "author_name")
String authorName;
int price;
}

/*
 {

 "title":"who will cry when you die"
 "authorName":"Rocklin Sharma"
 "price":92
 
 }
 
*/