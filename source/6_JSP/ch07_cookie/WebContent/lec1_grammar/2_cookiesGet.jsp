<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>쿠키값 리스트</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			out.println("생성된 쿠키가 없습니다.");
		}else{
			for(int i=0 ; i<cookies.length ; i++){ // 쿠키이름과 쿠키값
				String name = cookies[i].getName(); // i인덱스 쿠키 이름
				String value = cookies[i].getValue();// i인덱스 쿠키 값
				out.println("<h3>쿠키이름 : "+name+" / 쿠키값 : "+value+"</h3>");
			}
		}
	%>
	<hr>
	<a href="3_thatCookie.jsp">특정 쿠키가 있는지와 쿠키값 확인</a><br>
	<button onclick="location='3_thatCookie.jsp'">특정 쿠키 있는지와 쿠키값 확인</button>
</body>
</html>




















