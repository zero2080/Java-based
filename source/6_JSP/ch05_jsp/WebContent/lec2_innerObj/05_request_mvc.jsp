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
		String conPath = request.getContextPath();
										// /ch05_jsp
		String uri = request.getRequestURI();
										// /ch05_jsp/lec2_innerObj/05_request_mvc.jsp
		String command = uri.substring(conPath.length()+1); 
										// lec2_innerObj/05_request_mvc.jsp
	%>
	<h2>conPath : <%=conPath %></h2>
	<h2>uri : <%=uri %></h2>
	<h2>command : <%=command %></h2>
</body>
</html>















