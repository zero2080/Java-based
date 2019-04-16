<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	String validMem = (String)session.getAttribute("validMem");
	if(validMem==null)
		response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
		String id   = (String)session.getAttribute("id");
	%>
	<h1><%=name %>(<%=id %>)님 안녕하세요</h1>
	<a href="modify.jsp">회원정보수정</a><br>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>





















