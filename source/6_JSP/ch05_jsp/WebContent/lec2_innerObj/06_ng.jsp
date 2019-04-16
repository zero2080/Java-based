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
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h2><%=age %>살 아기네 때끼! 주류판매 불가</h2>
	<button onclick="history.go(-1)">이전</button>
</body>
</html>