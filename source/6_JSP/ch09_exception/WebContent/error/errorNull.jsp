<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외메세지 : <%=exception.getMessage()%>');
		console.log('예외타입 : <%=exception.getClass().getName()%>');
	</script>
</head>
<body>
	<h2>NullPointer예외. 공사중입니다</h2>
</body>
</html>