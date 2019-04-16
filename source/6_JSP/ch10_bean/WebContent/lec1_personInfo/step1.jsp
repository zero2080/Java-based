<%@page import="com.tj.ex.PersonInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		PersonInfo pi = new PersonInfo();
		//PersonInfo pi2 = new PersonInfo("홍길동",22,"남");
		pi.setName("홍길동");
		pi.setAge(22);
		pi.setGender("남");
	%>
	<h1>개인정보</h1>
	<h2>이름 : <%=pi.getName() %></h2>
	<h2>나이 : <%=pi.getAge() %></h2>
	<h2>성별 : <%=pi.getGender() %></h2>
</body>
</html>














