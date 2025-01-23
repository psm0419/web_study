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
	<h1>관리자 페이지</h1>
	<h2>유저 정보 수정</h2>

	<form action="" method="post">
		<label>유저 아이디: <input type="text" name="id" value="${user.id}" readonly></label><br>
		<label>유저 비번: <input type="text" name="pw" value="${user.pw}"></label><br>
		<label>유저 이름:  <input type="text" name="name" value="${user.name}"></label><br>
		<select name="userType">
			<option value="ADM" <c:if test="${user.userType == 'ADM'}">selected</c:if>>관리자</option>
			<option value="CUS" <c:if test="${user.userType == 'CUS'}">selected</c:if>>사용자</option>
		</select> <br> <br>
		
<%-- 		<label>사용자<input type="radio" name=userType value="CUS" <c:if test="${user.userType == 'CUS'}">checked</c:if>></label> --%>
<%-- 		<label>관리자<input type="radio" name=userType value="ADM" <c:if test="${user.userType == 'ADM'}">checked</c:if>></label> <br> --%>
		
		<button type="submit">수정하기</button>
		<button type="button" onClick="location.href ='/admin/users'">유저
			목록보기</button>
	</form>
</body>
</html>