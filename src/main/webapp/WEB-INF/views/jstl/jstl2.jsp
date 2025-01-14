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
	<h1>jstl2</h1>
	
	<c:set var="var1" value="값들어가는곳"/>
	${var1}
	
	<a href="/jstl/jstl1">jstl1 페이지</a>
	
	<c:url var="jstl1Url" value="/jstl/jstl1" />	
	<a href="${jstl1Url }">jstl1 curl</a>
	
	&gt;&gt;&gt;&gt;&gt;&gt;&lt;&lt;&lt;&lt;&lt;&lt;&lt;
	
	${msg1 }
	${msg2 }
	<c:out value="${msg1}" escapeXml="true"></c:out>
	<c:out value="${msg2}" escapeXml="true"></c:out>
<%-- 	${msgXml} --%>
	<c:out value="${msgXml}" escapeXml="true"></c:out>
	
	
<%-- 	<c:redirect url="/jstl/jstl1"></c:redirect> --%>
<!-- 	<script> -->
<!--  		location.href ="/jstl/jstl1"; -->
<!-- 	</script> -->
</body>
</html>