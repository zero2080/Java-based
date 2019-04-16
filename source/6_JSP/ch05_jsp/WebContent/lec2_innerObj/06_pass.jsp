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
	<h2><%=age %>살 성인이니 주류판매 가능합니다</h2>
	<button onclick="location.href='06_age.html'">이전</button>
</body>
</html>