<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>특정 쿠키(쿠키이름이 cookieN)가 있는지와 쿠키값 확인</h1>
	<%
		Cookie[] cookies = request.getCookies();
		String name=null, value=null;
		if(cookies!=null){
			for(Cookie c : cookies){
				name = c.getName();
				if(name.equals("cookieN")){
					value = c.getValue();
					break; // 해당 특정 쿠키를 찾으면 value에 쿠키값을 넣고 for문 빠져나감
				}
			}
		}
		if(value!=null){
			out.println("<h2>찾은 특정 쿠키 이름은 "+name+"</h2>");
			out.println("<h2>그 쿠키 값은 "+value+"</h2>");
		}else{
			out.println("<h2>찾고자 하는 특정 쿠키는 없습니다</h2>");
		}
	%>
	<hr>
	<button onclick="location='4_cookieDel.jsp'">쿠키(이름이 cookieN)삭제</button>
	<button onclick="location='2_cookiesGet.jsp'">쿠키리스트확인</button>
	<button onclick="history.back();">이전</button>
</body>
</html>




















