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
	<c:if test="${empty member && empty admin }">
		로그인 전 메뉴들
	</c:if>
	<c:if test="${not empty member && empty admin }">
		사용자 모드 메뉴들
	</c:if>
	<c:if test="${empty member && not empty admin }">
		관리자 모드 메뉴들
	</c:if>
</body>
</html>