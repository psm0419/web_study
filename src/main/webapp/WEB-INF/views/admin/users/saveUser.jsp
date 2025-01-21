<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 페이지</h1>
	<form action="" method="post">
		<label>아이디: <input type="text" name="id"></label><br>
<!-- 		<label>비번: <input type="password" name="pw"></label><br> -->
		<label>이름: <input type="text" name="name"></label><br>
<!-- 		<label>유저타입: <input type="text" name="userType" value="CUS"></label><br> -->
		<button type="submit">유저 추가</button>
	</form>
</body>
</html>