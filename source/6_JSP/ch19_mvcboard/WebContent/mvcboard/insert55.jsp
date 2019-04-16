<%@page import="com.tj.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		for(int i=0 ; i<55 ; i++){
			BoardDao dao = new BoardDao();
			dao.write("hong"+i, "title"+i, "content\r\ntest", "192.168.10.151");
		}
		response.sendRedirect("../list.do");
	%>
</body>
</html>