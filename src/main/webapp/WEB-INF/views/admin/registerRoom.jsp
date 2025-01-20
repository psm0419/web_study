<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>객실 추가</h1>
	
	<form action="" method="post">
		<label>건물/동 번호 <input type="text" name="buildingNumber"></label>
		<label>호실번호 <input type="text" name="roomNumber"></label>
		<label>층수 <input type="text" name="floor"></label>
		<label>최대숙박 인원 <input type="text" name="maxGuestCount"></label>
		
		<select name="viewType">
			<option value="OCN">OCN</option>
			<option value="CTY">CTY</option>
			<option value="MOT">MOT</option>
		</select>
		
		<br>
		<button type="submit">객실추가</button>
	</form>
</body>
</html>