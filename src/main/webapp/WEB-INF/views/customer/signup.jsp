<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error-msg {
		color: red
}
</style>
</head>
<body>
	<h2>회원가입 페이지</h2>

	<form action="" method="post">
		<label>아이디: <input type="text" name="id" id="inputId"
			value="${user.id}"></label><br>
			<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('id')}">
				<p class="error-msg">아이디 필수로 입력하세요!</p>
			</c:if>
		</spring:hasBindErrors>
		
		<c:if test="${userVaildError.id != null}">
			<p class="error-msg">${userVaildError.id}</p>
		</c:if>	
		
		<button type="button" id="btn_checkDupId">중복체크</button>
		<span id="checkDupMsg"></span> <br> 
		
		<label>비번: <input type="password" name="pw"></label><br>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pw')}">
				<p class="error-msg">비밀번호는 8자리~12자리로 입력해주세요!</p>
				<p class="error-msg">"${errors.hasFieldErrors('pw').defaultMessage}"</p>
			</c:if>
		</spring:hasBindErrors>
		<label>이름: <input type="text" name="name" value="${user.name}"></label><br>
		<button type="submit">회원가입</button>
	</form>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		let btn_checkDupId = document.getElementById('btn_checkDupId');
		btn_checkDupId.addEventListener('click', ()=>{
// 			location.href = "/customer/checkDupId";
		let inputId = document.getElementById('inputId').value;
		let span_checkDupMsg = document.getElementById('checkDupMsg');
		
		let objData = { //자바스크립트 오브젝트 타입
				'id': inputId,
				'type':'CUS'
		};
		//자바스크립트 오브젝트 -> JSON format Text
		//obj -> JSON		JSON.stringufy
		//JSON -> obj		JSON.parse
		let JsonData = JSON.stringify(objData);
		
		//서버로 ajax 요청 아이디 중복 여부 확인
		$.ajax({
		    type: "POST", 		// 타입 (get, post, put 등등)
		    url: "http://localhost:8080/customer/checkDupIdJson", // 요청할 서버url
		    headers: { 		// Http header
		      "Content-Type":"application/json;"
		    },
		    data: JsonData,
		    dataType: 'json',
		    success: function(result) { // 결과 성공 콜백함수
		        console.log("ajax success");
		        console.log(result);
		        
		        if(result.header.resultCode == 10){
		        	if(result.body == 'Y'){ //중복
			        	span_checkDupMsg.textContent = '중복된 아이디입니다';
			        }else{ //중복X
			        	span_checkDupMsg.textContent = '사용 가능한 아이디입니다';
			        }
		        } else{
		        	cosole.log('정상 응답을 받지 못함');
		        }
		        
		        
		    },
		    error: function(error) { // 결과 에러 콜백함수
		        console.log(error);
		    }
			});
			
			//단일 id 전송, 단일 text 수신
// 			$.ajax({
// 			    type: "POST", 		// 타입 (get, post, put 등등)
// 			    url: "http://localhost:8080/customer/checkDupId", // 요청할 서버url
// 			    headers: { 		// Http header
// 			      "Content-Type":"application/json;"
// 			    },
// 			    data: inputId,
// 			    success: function(result) { // 결과 성공 콜백함수
// 			        console.log("ajax success");
// 			        console.log(result);
// 			        if(result == 'Y'){ //중복
// 			        	span_checkDupMsg.textContent = '중복된 아이디입니다';
// 			        }else{ //중복X
// 			        	span_checkDupMsg.textContent = '사용 가능한 아이디입니다';
// 			        }
// 			    },
// 			    error: function(error) { // 결과 에러 콜백함수
// 			        console.log(error);
// 			    }
// 				});
			});
	</script>

</body>
</html>