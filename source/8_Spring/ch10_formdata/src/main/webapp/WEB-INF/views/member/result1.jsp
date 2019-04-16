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
	<h1>입력한 개인정보</h1>
	<hr>
	<h2>이름 : ${name }</h2>
	<h2>아이디 : ${id }</h2>
	<h2>비밀번호 : ${pw }</h2>
	<h2>나이 : ${age }</h2>
	<h2>이메일 : ${email }</h2>
	<h2>주소 : ${address }</h2>
	<hr>
	<button onclick="history.back()">뒤로가기</button>
	<button onclick="location.href='${conPath}/'">처음으로가기</button>
</body>
</html>