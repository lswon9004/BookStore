package com.spring.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.OrdersDao;
import com.spring.dto.Customer;
import com.spring.dto.Orders;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class OrdersService {
	@Autowired
	OrdersDao dao;

	public List<Orders> result(Date start, Date end) {
		return dao.searchOdrder(start, end);
	}

	public List<Customer> searchName(String name) {
		return dao.searchName("%" + name + "%");
	}

	public void ordersExcel(List<Orders> olist, HttpServletResponse response) {
		String fileName = "";
		try {
			fileName = new String(("olist_검색.xlsx").getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 엑셀파일 다운로드 설정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

		Workbook workbook = new SXSSFWorkbook(); // excel문서
		Sheet sheet = workbook.createSheet("주문정보");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("이름");
		cell = row.createCell(1);
		cell.setCellValue("책이름");
		cell = row.createCell(2);
		cell.setCellValue("구매날짜");
		cell = row.createCell(3);
		cell.setCellValue("판매가격");

		// Body
		for (Orders m : olist) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(m.getCustomer().getName());

			cell = row.createCell(1);
			cell.setCellValue(m.getBook().getBookname());

			cell = row.createCell(2);
			cell.setCellValue(format(m.getOrderdate()));

			cell = row.createCell(3);
			cell.setCellValue(m.getSaleprice());

		}
		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void customerExcel(List<Customer> clist, HttpServletResponse response) {
		String fileName = "";
		try {
			fileName = new String(("clist_검색.xlsx").getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 엑셀파일 다운로드 설정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");

		Workbook workbook = new SXSSFWorkbook(); // excel문서
		Sheet sheet = workbook.createSheet("고객정보");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("custid");
		cell = row.createCell(1);
		cell.setCellValue("이름");
		cell = row.createCell(2);
		cell.setCellValue("주소");
		cell = row.createCell(3);
		cell.setCellValue("전화번호");

		// Body
		for (Customer m : clist) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(m.getCustid());

			cell = row.createCell(1);
			cell.setCellValue(m.getName());

			cell = row.createCell(2);
			cell.setCellValue(m.getAddress());

			cell = row.createCell(3);
			cell.setCellValue(m.getPhone());

		}
		try {
			workbook.write(response.getOutputStream());
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String format(Date orderdate) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		return sdf1.format(orderdate);
	}

}
