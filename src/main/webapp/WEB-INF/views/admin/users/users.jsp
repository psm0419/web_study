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
	<div>
		<form action="" method="get">
			<span>검색기준</span>
			<label>아이디 <input type="checkbox" name="id" <c:if test="${userSearchCondition.id != null }">checked</c:if>> </label>
			<label>이름 <input type="checkbox" name="name" <c:if test="${userSearchCondition.name != null }">checked</c:if>> </label> <br>
			<label><input type="radio" name="userType" value="ADM" <c:if test="${userSearchCondition.userType == 'ADM'}">checked</c:if>>관리자</label>
			<label><input type="radio" name="userType" value="CUS" <c:if test="${userSearchCondition.userType == 'CUS'}">checked</c:if>>사용자</label>
			
			<label>검색어: <input type="text" name="userSearchKeyword" value="${userSearchCondition.userSearchKeyword}"></label>
			<button type= "submit">검색</button>
		</form>
	</div>
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
		function modifyUser(id) {
			location.href = '/admin/users/' + id;
		}
	</script>
</body>
</html>