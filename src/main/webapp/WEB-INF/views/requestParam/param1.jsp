<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>param1 page</h1>

	<div>
		<form action="/param2" method="post">
			<input type="text" name="name"> 
<!-- 			request.getParameter("name") 여기와 이름 같아야함 -->
			<input type="text" name="count">
			<button type="submit">전송</button>
		</form>
		
		<a href="/param2?name=asdasd&count=123212">param2로</a>
		
	</div>
</body>
</html>