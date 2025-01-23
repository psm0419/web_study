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
	<h2>유저 목록</h2>
	<c:forEach var="user" items="${userList}">
		<p>
<!-- 			<a href="/admin/users/user"> -->
			유저 아이디: ${user.id} 유저 이름: ${user.name}
			<c:choose>
				<c:when test="${user.userType == 'CUS'}">유저 타입: 사용자</c:when>
				<c:when test="${user.userType == 'ADM'}">유저 타입: 관리자</c:when>
			</c:choose>
<!-- 			</a> -->
			<button type="button" onClick="modifyUser('${user.id}')">수정하기</button>

		</p>
		<br>
	</c:forEach>
	
	<script>
		function modifyUser(id){
			location.href ='/admin/users/'+ id;
		}
	</script>
</body>
</html>