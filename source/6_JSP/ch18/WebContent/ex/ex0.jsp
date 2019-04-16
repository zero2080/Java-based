<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
	%>
	<h1>url : <%=url %></h1>
	<h1>uri : <%=uri %></h1>
	<h1>conPath : <%=conPath %></h1>
	<h1>요청한 것 : <%=command %></h1>
</body>
</html>