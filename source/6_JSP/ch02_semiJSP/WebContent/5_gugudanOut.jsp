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
		int dansu = Integer.parseInt(request.getParameter("dansu"));
	%>
	<h2><%=dansu%>단 구구단 출력</h2>
	<%	for(int i=1 ; i<10 ; i++){%>
		<h2><%=dansu %> * <%=i %> = <%=dansu*i %></h2>
	<%	} %>
	<br><br>
	<button onclick="location.href='5_inputDansu.html'">뒤로가기</button>
</body>
</html>


