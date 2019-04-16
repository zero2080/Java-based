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
	<c:choose>
		<c:when test="${param.num eq 0 }">
			<h2>첫 방문 환영합니다</h2>
		</c:when>
		<c:when test="${param.num eq 1 }">
			<h2>두번째 방문 감사합니다</h2>
		</c:when>
		<c:when test="${param.num > 1 }">
			<h2>자주 자주 봅시다</h2>
		</c:when>
		<c:otherwise>
			<h1>제대로 된 방문횟수를 입력받지 못했습니다</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>