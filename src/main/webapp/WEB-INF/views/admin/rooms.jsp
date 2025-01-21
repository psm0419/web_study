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
	<h2>rooms 객실 목록</h2>
	<c:forEach var="roomItem" items="${roomList}">
		<p>룸 아이디: ${roomItem.roomId}</p>
		<p>빌딩 넘버: ${roomItem.buildingNumber}</p>
		<p>룸 넘버: ${roomItem.roomNumber}</p>
		<p>층: ${roomItem.floor}</p>
		<p>최대 투숙객수: ${roomItem.maxGuestCount}</p>
		<p>
			<c:choose>
				<c:when test="${roomItem.viewType == 'OCN'}">뷰 타입: 오션뷰</c:when>
				<c:when test="${roomItem.viewType == 'CTY'}">뷰 타입: 시티뷰</c:when>
				<c:when test="${roomItem.viewType == 'MOT'}">뷰 타입: 마운틴뷰</c:when>
			</c:choose>
		</p>
		<br>
	</c:forEach>
</body>
</html>