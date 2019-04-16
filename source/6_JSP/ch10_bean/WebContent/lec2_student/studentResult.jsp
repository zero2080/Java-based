<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="com.tj.ex.Student" scope="request"/>
	<h1>학생정보</h1>
	<h2>학번 : <jsp:getProperty name="student" property="studentNum"/></h2>
	<h2>이름 : <jsp:getProperty name="student" property="name"/></h2>
	<h2>학년 : <jsp:getProperty name="student" property="grade"/></h2>
	<h2>점수 : <jsp:getProperty name="student" property="score"/></h2>
</body>
</html>