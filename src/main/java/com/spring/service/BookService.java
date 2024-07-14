package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BookDao;
import com.spring.dto.Book;

@Service
public class BookService {
	@Autowired
	BookDao dao;
	
	public Book[] bookAll() {
		return dao.bookAll();
	}
	public int insertBook(Book book) {
		return dao.insertBook(book);
	}
	public int getid() {
		return dao.getid();
	}
	public int updateBook(Book book) {
		return dao.updateBook(book);
	}
}
