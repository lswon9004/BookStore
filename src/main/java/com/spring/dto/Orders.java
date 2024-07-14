package com.spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Orders {
	int orderid;
	int custid;
	int bookid;
	int saleprice;
	Date orderdate;
	String bname;
	
	Customer customer;
	Book book;
}
