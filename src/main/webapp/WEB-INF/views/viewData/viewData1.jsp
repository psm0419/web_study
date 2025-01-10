<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewData1 페이지</h1>
	
<!-- 	자바코드를 사용하는 영역 -->
	<%=request.getAttribute("state")%>
	<%=request.getAttribute("time")%>
	
	<p>${state}</p>
	<p>${time}</p>
	
</body>
</html>