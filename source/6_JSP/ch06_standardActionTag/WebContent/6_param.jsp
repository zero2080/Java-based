<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>6_param.jsp파일입니다</h1>
	<hr>
	<jsp:include page="5_param.jsp">
		<jsp:param name="id" value="hong"/>
		<jsp:param name="pw" value="1111"/>
	</jsp:include>
	<hr>
	<h1>다시 6_param.jsp파일입니다</h1>
</body>
</html>



















