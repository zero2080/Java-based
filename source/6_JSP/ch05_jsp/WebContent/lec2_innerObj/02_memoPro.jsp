<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name"); // 작성자
		String memo = request.getParameter("memo"); // 한줄메모
		String ip = request.getRemoteAddr(); // 메모 남긴 곳의 ip
		Date now = new Date(System.currentTimeMillis());//메모남긴 시점
		//java.util.Date now2 = new java.util.Date();
	%>
	<h2>작성자 : <%=name %></h2>
	<h2>한줄메모 : <%=memo %></h2>
	<h2>작성한 곳 IP : <%=ip %></h2>
	<h2>작성시점 : <%=now %></h2>
</body>
</html>







