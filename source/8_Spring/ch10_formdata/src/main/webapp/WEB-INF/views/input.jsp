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
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('button').click(function(){
				var studentId = $('input[name="studentId"]').val();
				location.href = '${conPath}/student/'+studentId;
			});
		});
	</script>
</head>
<body>
	<h1>@ModelAttribute를 이용한 model 객체들(list, cnt) 출력</h1>
	<h3>list : 
	<c:forEach var="l" items="${list }">
		${l } &nbsp; &nbsp;  
	</c:forEach>
	</h3>
	<h3>cnt : ${cnt }</h3>
	<!-- <form action="member/join1"> -->
	<!-- <form action="member/join2"> -->
	<!-- <form action="member/join3"> -->
	<form action="member/join4">
		<table>
			<caption>개인정보 입력</caption>
			<tr><th>이름</th><td><input type="text" name="name"></td></tr>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>나이</th><td><input type="number" name="age"></td></tr>
			<tr><th>이메일</th><td><input type="email" name="email"></td></tr>
			<tr><th>주소</th><td><input type="text" name="address"></td></tr>
			<tr><td colspan="2"><input type="submit" value="전송"></td></tr>
		</table>
	</form>
	
	<p><a href="${conPath }/student/aaa">aaa아이디를 요청경로에 넣어 요청</a></p>
	
	<p>
		studendtId : <input type="text" name="studentId">
		<button>아이디를 요청경로에 넣어 요청</button>
	</p>
</body>
</html>