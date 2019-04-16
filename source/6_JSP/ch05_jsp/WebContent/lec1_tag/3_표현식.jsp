<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a=10, b=11;
%>
	<h2><%=2 %></h2>
	<h2><%=2*3%3 %></h2>
	<h2><%=(a<11)||(b>10) %></h2>
	<h2>지금은 <%=new Date(System.currentTimeMillis()) %></h2>
	<h2>1~3까지 아무수나 랜덤 : <%=(int)(Math.random()*3)+1 %></h2>
</body>
</html>