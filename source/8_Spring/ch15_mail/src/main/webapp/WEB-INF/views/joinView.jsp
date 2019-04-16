<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>메일 작성해서 회원가입버튼 누르면 환영메일 감</h1>
	<form action="textMail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="mailaddr" required="required"></p>
		<input type="submit" value="회원가입(TEXT단순 메일감-HTML 못 씌움)">
	</form>
	<form action="mail">
		<p>이름 <input type="text" name="name" required="required"></p>
		<p>메일 <input type="email" name="mailaddr" required="required"></p>
		<input type="submit" value="회원가입(HTML 형태로 넘어감)">
	</form>
	
</body>
</html>