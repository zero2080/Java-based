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
	<h1>입력한 개인정보(result4.jsp)입니다</h1>
	<hr>
	<h2>이름 : ${member.name }</h2>
	<h2>아이디 : ${member.id }</h2>
	<h2>비밀번호 : ${member.pw }</h2>
	<h2>나이 : ${member.age }</h2>
	<h2>이메일 : ${member.email }</h2>
	<h2>주소 : ${member.address }</h2>
	<button onclick="history.go(-1)">뒤로가기</button>
</body>
</html>