<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>#wrap{width:200px; margin: 0 auto;}</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id   = request.getParameter("id");
	String pw   = request.getParameter("pw");
%>
	<div id="wrap">
		<p>아이디는 <%=id %>이고,</p>
		<p>패스워드는 <%=pw %> 입니다</p>
		<br>
		<p><%=name %>님 반갑습니다</p>
	</div>
</body>
</html>













