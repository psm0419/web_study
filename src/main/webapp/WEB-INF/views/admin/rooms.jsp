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

	<button id="btnRegisterRoom">객실 추가하기</button>
	<br>

	<c:forEach var="room" items="${roomList}">

		<p>
			<a href="/admin/room/${room.roomId}">
			룸 아이디: ${room.roomId}
			빌딩 넘버: ${room.buildingNumber}
			룸 넘버: ${room.roomNumber}
			층: ${room.floor}
			최대 투숙객수: ${room.maxGuestCount}			
				<c:choose>
					<c:when test="${room.viewType == 'OCN'}">뷰 타입: 오션뷰</c:when>
					<c:when test="${room.viewType == 'CTY'}">뷰 타입: 시티뷰</c:when>
					<c:when test="${room.viewType == 'MOT'}">뷰 타입: 마운틴뷰</c:when>
				</c:choose>
			</a>
<!-- 			바로삭제 -->
<%-- 			<button type="button" onClick="location.href ='/admin/removeRoom?roomId=${room.roomId}'">삭제하기</button> --%>
			<button type="button" onClick="removeRoom(${room.roomId})">삭제하기</button>
		</p>
		
		<br>
	</c:forEach>

	<script>
		const btn_registerRoom = document.getElementById("btnRegisterRoom");
		btn_registerRoom.addEventListener('click', ()=> {
			location.href = "/admin/registerRoom";
		});
		
		function removeRoom(roomId){
			
			if(confirm("정말 삭제하시겠습니까?")){
				location.href ='/admin/removeRoom?roomId='+ roomId;
			}
		};
		
	</script>


</body>
</html>