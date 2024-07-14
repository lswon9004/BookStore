<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
${start}
<c:forEach items="${blist}" var="dept">
	${ dept.bookid} / ${dept.bookname } / ${dept.publisher}/ ${dept.price} 
	<br> 
</c:forEach>
</body>
</html>