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
	<h2>객실 단일 정보 조회 페이지</h2>

	<p>룸 아이디: ${room.roomId}</p>
	<p>빌딩 넘버: ${room.buildingNumber}</p>
	<p>룸 넘버: ${room.roomNumber}</p>
	<p>층: ${room.floor}</p>
	<p>최대 투숙객수: ${room.maxGuestCount}</p>
	<p>
		<c:choose>
			<c:when test="${room.viewType == 'OCN'}">뷰 타입: 오션뷰</c:when>
			<c:when test="${room.viewType == 'CTY'}">뷰 타입: 시티뷰</c:when>
			<c:when test="${room.viewType == 'MOT'}">뷰 타입: 마운틴뷰</c:when>
		</c:choose>
	</p>
	
	<button type="button" onClick="location.href ='/admin/rooms'">객실 목록보기</button>
</body>
</html>