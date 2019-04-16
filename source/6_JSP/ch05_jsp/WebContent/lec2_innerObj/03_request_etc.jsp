<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath %>/css/03.css" rel="stylesheet">
</head>
<body>	
	<h2>컨텍스트path : <%=conPath %></h2>
	<hr>
	<a href="../lec1_tag/a.jsp">a.jsp</a><br>
	<a href="http://localhost:8181/ch05_jsp/lec1_tag/a.jsp">a.jsp</a><br>
	<a href="<%=conPath %>/lec1_tag/a.jsp">a.jsp</a><br>
	<hr>
	<a href="../Ex03">Ex03서블릿</a><br>
	<a href="http://localhost:8181/ch05_jsp/Ex03">Ex03서블릿</a><br>
	<a href="<%=conPath %>/Ex03">Ex03서블릿</a><br>
</body>
</html>















