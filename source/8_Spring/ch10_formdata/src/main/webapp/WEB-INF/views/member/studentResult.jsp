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
	<h1>@ModelAttribute를 이용한 model 객체들(list, cnt) 출력</h1>
	<h3>list : 
	<c:forEach var="l" items="${list }">
		${l } &nbsp; &nbsp;  
	</c:forEach>
	</h3>
	<h3>cnt : ${cnt }</h3>
	<h1>studentResult.jsp입니다</h1>
	<h2>입력한 studentId : ${id }</h2>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>