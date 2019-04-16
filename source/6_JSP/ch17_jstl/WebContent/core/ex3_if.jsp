<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${1+2 eq 3}" var="result" scope="request">
		<h2>1+2는 3입니다</h2>
	</c:if>
	<c:if test="${1+2 != 3 }">
		<h2>1+2는 3이 아닙니다</h2>
	</c:if>
	<c:set var="result" value="123"/>
	<c:out value="${result }"/>
</body>
</html>