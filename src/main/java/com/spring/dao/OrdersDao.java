package com.spring.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.spring.dto.Customer;
import com.spring.dto.Orders;


@Mapper
public interface OrdersDao {

	@Select("select name as 'customer.name', bookname as 'book.bookname', orderdate, saleprice "
			+"from orders o natural join customer c natural join book b "
			+ "where orderdate between #{start} and #{end}")
	List<Orders> searchOdrder(@Param("start") Date start, @Param("end") Date end);
	
	@Select("select * from customer where name like #{name}")
	List<Customer> searchName(@Param("name") String name);
}
