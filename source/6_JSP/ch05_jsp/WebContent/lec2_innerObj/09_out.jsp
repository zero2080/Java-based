<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="4kb" %>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		out.println("<h1>TEST</h1>");
		out.println("<h1>버퍼의 크기 : "+out.getBufferSize()+"</h1>");
		out.println("<h1>남은 버퍼는 : "+out.getRemaining()+"</h1>");
	%>
</body>
</html>