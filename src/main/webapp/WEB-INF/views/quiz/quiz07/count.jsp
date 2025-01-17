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
	<%-- 	${id != null} 그냥써도 가장가까운것으로 인식(request > session) --%>
	<c:if test="${sessionScope.id != null}"> 
			${id}이 접속하셨습니다. <br>
			접속횟수: ${count}
	</c:if>
	
	<c:if test="${sessionScope.id == null}"> 
			접속한 사용자가 없습니다. <br>
			접속횟수: ${count}
	</c:if>
	

</body>
</html>