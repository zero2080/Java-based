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
		Cookie cookie = new Cookie("cookieN","cookieV");
		cookie.setMaxAge(60*60);//1시간 유효한 쿠키
		response.addCookie(cookie);
		Cookie cookie2 = new Cookie("id","aaa");
		cookie2.setMaxAge(60*60);//1시간 유효한 쿠키
		response.addCookie(cookie2);
	%>
	<h2>지금 막 생성된 쿠키 이름 : <%=cookie.getName() %></h2>
	<h2>지금 막 생성된 쿠키의 값 : <%=cookie.getValue() %></h2>
	<hr>
	<a href="2_cookiesGet.jsp">쿠키값들 리스트 확인</a><br>
	<button onclick="location.href='2_cookiesGet.jsp'">쿠키값들 리스트 확인</button>
	<hr>
	<a href="3_thatCookie.jsp">특정 쿠키가 있는지와 쿠키값 확인</a><br>
	<button onclick="location='3_thatCookie.jsp'">특정 쿠키 있는지와 쿠키값 확인</button>
</body>
</html>















