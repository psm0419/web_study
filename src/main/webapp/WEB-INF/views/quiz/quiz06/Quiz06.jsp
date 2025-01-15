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
	<h2>페이지에서 필터링</h2>
	<c:choose>
		<c:when test="${auth == 'basic' }">
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == auth}">
					<h3>${member.id} ${member.pw} ${member.name} ${member.type}</h3>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'manager' }">
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == auth}">
					<h3>${member.id} ${member.pw} ${member.name} ${member.type}</h3>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'admin' }">
			<c:forEach var="member" items="${memberList}">
				<h3>${member.id} ${member.pw} ${member.name} ${member.type}</h3>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>정체불명입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<hr>
	<hr>
	<h2>필터링후 리스트 넘어왔을때</h2>
		<c:forEach var="member" items="${viewMemberList}">
			<h3>${member.id} ${member.pw} ${member.name} ${member.type}</h3>
		</c:forEach>
	
</body>
</html>