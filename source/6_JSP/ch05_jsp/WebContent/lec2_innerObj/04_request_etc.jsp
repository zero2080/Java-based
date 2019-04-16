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
		out.println("컨텍스트path : "+request.getContextPath()+"<br>");
		out.println("요청 URI : "+request.getRequestURI()+"<br>");
		out.println("요청 URL : "+request.getRequestURL()+"<br>");
		out.println("요청 방식 : "+request.getMethod()+"<br>");
		out.println("해당 프로토콜 : "+request.getProtocol()+"<br>");
		out.println("서버 이름 : "+request.getServerName()+"<br>");
		out.println("포트번호 : "+request.getServerPort()+"<br>");
	%>
</body>
</html>