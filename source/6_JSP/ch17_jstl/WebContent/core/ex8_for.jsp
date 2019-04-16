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
	<%
		String[] names = {"홍길동","김길동","신길동"};
		for(String name : names){
			out.print(name+"<br>");
		}
	%>
	<c:set var="names" value="<%=names %>"/>
	<c:set var="idx" value="0"/>
	<c:forEach var="name" items="${names }" begin="0" end="1">
		${idx} : ${name }<br>
		<c:set var="idx" value="${idx+1 }"/>
	</c:forEach>
</body>
</html>