<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("id") || c.getName().equals("pw")){
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
	%>
	<button onclick="location='login.html'">로그인</button>
	<button onclick="location='<%=conPath%>/lec1_grammar/2_cookiesGet.jsp'">
		쿠키 리스트 확인
	</button>
	<hr>
	<h1>로그아웃되었습니다</h1>
</body>
</html>













