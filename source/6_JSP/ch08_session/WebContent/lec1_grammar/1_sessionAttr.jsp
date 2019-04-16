<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 쿠키 생성 == 세션에 데이터(attribute)추가 -->
	<%
		session.setAttribute("myStr", "myData");
		session.setAttribute("myNum", new Integer(111));
	%>
	<h2>지금 추가한 세션 데이터 : <%=session.getAttribute("myStr") %></h2>
	<h2>지금 추가한 세션 데이터 : <%=session.getAttribute("myNum") %></h2>
	<a href="2_sessionGet.jsp">세션Get</a>
</body>
</html>