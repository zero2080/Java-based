<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request"/>
	<h1>개인정보</h1>
	<h2>이름 : <jsp:getProperty name="pi" property="name"/></h2>
	<h2>나이 : <jsp:getProperty name="pi" property="age"/></h2>
	<h2>성별 : <jsp:getProperty name="pi" property="gender"/></h2>
</body>
</html>