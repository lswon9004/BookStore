<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h4><fmt:formatDate value="${start}" pattern="yyyy/MM/dd"/>부터 <fmt:formatDate value="${end}" pattern="yyyy/MM/dd"/>까지의 구매내역입니다</h4>
<table border="1">
<tr><th>이름</th><th>책이름</th><th>구매날짜</th><th>가격</th></tr>
<c:forEach items="${olist}" var="dept">
	<tr><td>${ dept.customer.name}</td> <td>${dept.book.bookname }</td> <td> <fmt:formatDate value="${dept.orderdate}" pattern="yyyy/MM/dd"/></td><td> ${dept.saleprice}</td></tr>
	
</c:forEach>

</table>
</body>
</html>