<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex2_inputView.jsp">
		ID : <input type="text" name="id"><br>
		다음 중 회원님이 키우고 있는 애완동물을 선택하세요<br>
		개 <input type="checkbox" name="pets" value="개">
		고양이 <input type="checkbox" name="pets" value="고양이">
		금붕어 <input type="checkbox" name="pets" value="금붕어">
		개구리 <input type="checkbox" name="pets" value="개구리"><br>
		<input type="submit">
	</form>
</body>
</html>