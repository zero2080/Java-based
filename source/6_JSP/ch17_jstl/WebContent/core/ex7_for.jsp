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
	<c:forEach var="i" begin="1" end="100" step="100">
		<h2>${i } : 안녕하세요</h2>
	</c:forEach>
</body>
</html>