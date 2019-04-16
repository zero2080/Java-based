<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>4_param.jsp파일입니다</h1>
	<jsp:forward page="5_param.jsp">
		<jsp:param name="id" value="hong"/>
		<jsp:param name="pw" value="1111"/>
	</jsp:forward>
</body>
</html>














