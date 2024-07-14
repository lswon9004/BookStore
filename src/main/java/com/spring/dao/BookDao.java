package com.spring.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.dto.Book;

@Mapper
public interface BookDao {
	
	@Select("select * from book")
	Book[] bookAll();
	
	@Insert("insert into book values(#{bookid}, #{bookname}, #{publisher}, #{price})")
	int insertBook(Book book);
	
	@Select("select max(bookid) from book")
	int getid();
	
	@Update("update book set bookname = #{bookname} where bookid = #{bookid}")
	int updateBook(Book book);
}
