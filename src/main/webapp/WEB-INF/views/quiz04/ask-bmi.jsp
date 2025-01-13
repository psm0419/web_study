<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ask bmi</h1>
	<!-- 	공개해도 상관없는 정보는 GET 으로 보내도 된다 -->
	<form action="/quiz04/result-bmi" method="post"> 
	    이름: <input type="text" name="name">
	    키: <input type="text" name="height">
	    몸무게: <input type="text" name="weight">
	    <button type="submit">전송</button>
	</form>
</body>
</html>