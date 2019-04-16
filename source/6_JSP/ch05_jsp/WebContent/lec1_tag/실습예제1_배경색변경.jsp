<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String color=request.getParameter("color");
%>
<style>
	body {background-color:<%=color%>; }
</style>
</head>
<body>
	<h1>배경색이 <%=color %>색으로 변경</h1>
</body>
</html>