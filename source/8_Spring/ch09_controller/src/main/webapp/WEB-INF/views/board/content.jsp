<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>board/content.jsp입니다</h1>
	<hr>
	<h2>ID : ${id }</h2>
	<h2>pw : ${pw }</h2>
	<h2>member : ${member.toString() }</h2>
	<h2>member의 id : ${member.id }</h2>
	<h2>member의 pw : ${member.pw }</h2>
	<hr>
	<h3 onclick="history.back()">뒤로 가기</h3>
</body>
</html>













