<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.tj.dto.FriendDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		FriendDao fDao = FriendDao.getInstance();
		int result = fDao.friendInsert(dto);
		response.sendRedirect("friendInput2.jsp?result="+result);
	%>
</body>
</html>