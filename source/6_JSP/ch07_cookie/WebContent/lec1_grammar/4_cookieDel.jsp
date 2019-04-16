<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% /* 특정 쿠키 삭제 : 특정 쿠키 찾고 -> 
								같은 이름의 0초짜리 쿠키 response객체에 보내면
								같은 이름의 쿠키는 덮어씌워짐
			*/
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				String name = c.getName();
				if(name.equals("cookieN")){ // 특정 쿠키이면 삭제
					/* Cookie cookie = new Cookie("cookieN","xx");
					cookie.setMaxAge(0);
					response.addCookie(cookie); */
					c.setMaxAge(0);
					response.addCookie(c);
					out.println("<h2>쿠키 삭제 성공</h2>");
					break;
				}
			}
		}
	%>
	<button onclick="location='2_cookiesGet.jsp'">쿠키리스트 확인</button>
	<button onclick="location='3_thatCookie.jsp'">특정쿠키 확인</button>
	<button onclick="location='1_cookieConstruct.jsp'">쿠키생성</button>
</body>
</html>



















