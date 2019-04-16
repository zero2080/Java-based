<%@page import="com.tj.ex.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.tj.ex.MemberInfo" scope="page"/>
	<jsp:setProperty name="member" property="*"/>
	<h1>bean태그 이용한 정보</h1>
	<h3>이름 <jsp:getProperty name="member" property="name"/> </h3>
	<h3>아이디 <jsp:getProperty name="member" property="id"/> </h3>
	<h3>비번 <jsp:getProperty name="member" property="pw"/> </h3>
	<h1>EL 표기법을 이용한 정보</h1>
	<h3>이름 ${member.name} </h3>
	<h3>아이디 ${member.id } </h3>
	<h3>비번 ${member.pw } </h3>
	<h1>표현식을 이용한 사용</h1>
	<h3>이름 <%=member.getName() %></h3>
	<hr>
	<%
		MemberInfo mi = new MemberInfo(); 
		mi.setName("홍길순"); mi.setId("aaa"); mi.setPw("111");
	%>
	<h1>mi 출력(표현식)</h1>
	<h3>이름 <%=mi.getName() %></h3>
	<h3>아이디 <%=mi.getId() %></h3>
	<h3>비번 <%=mi.getPw()%></h3>
	<h1>mi 출력(EL 표기법)</h1>
	<h3>이름 ${mi.name }</h3>
	<h3>아이디 ${mi.id }</h3>
	<h3>비번 ${mi.pw }</h3>
</body>
</html>












