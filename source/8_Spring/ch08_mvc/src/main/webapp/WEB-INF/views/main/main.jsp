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
	<h1>main폴더의 main.jsp입니다</h1>
	<h2><span onclick="history.go(-1)">뒤로가기</span></h2>
	<img src="${conPath }/img/f.jpg" alt="그림">
</body>
</html>