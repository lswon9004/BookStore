<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="result">
	<input type="date" name="start">
	<input type="date" name="end">
	<button>전송</button>
</form>
<form action="insertBook">
	<input type="number" name="bookid" readonly="readonly" value="${bookid+1}">
	<input name="bookname">
	<input name="publisher">
	<input type="number" name="price">
	<button>삽입</button>
</form>
<form action="update">
	<input name="bookname">
	<input name="bookid" type="number">
	<button>갱신</button>
</form>
<form action="name">
	<input name="name">
	<button>이름</button>
</form>
</body>
</html>