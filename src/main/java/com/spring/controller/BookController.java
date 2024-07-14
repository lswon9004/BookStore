package com.spring.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Book;
import com.spring.dto.Customer;
import com.spring.dto.Orders;
import com.spring.service.BookService;
import com.spring.service.OrdersService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class BookController {
	@Autowired
	BookService bser;
	
	@Autowired
	OrdersService oser;
	
	@GetMapping("/book")
	public String book(Model m) {
		Book[] blist = bser.bookAll();
		m.addAttribute("blist", blist);
		return "book/book";
	}
	@GetMapping("/book/form")
	public String form(Model m) {
		int id = bser.getid();
		m.addAttribute("bookid",id);
		return "book/form";
	}
	@GetMapping("/book/result")
	public String search(@RequestParam("start")@DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
						 @RequestParam("end")@DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
						 Model m, HttpServletResponse response) {
		
		List<Orders> olist = oser.result(start, end);
		oser.ordersExcel(olist, response);
		m.addAttribute("olist", olist);
		m.addAttribute("start", start);
		m.addAttribute("end", end);
		return "book/result";
	}
	@GetMapping("/book/insertBook")
	public void insertBook(Book book, Model ms) {
		int i = bser.insertBook(book);
		ms.addAttribute("ib", i);
	}
	@GetMapping("/book/update")
	public void updateBook(Book book, Model m) {
		int i = bser.updateBook(book);
		m.addAttribute("ub", i);
	}
	@GetMapping("/book/name")
	public void nameExcel(@RequestParam("name") String name, HttpServletResponse response) {
		List<Customer> clist = oser.searchName(name);
		oser.customerExcel(clist, response);
	}
}
