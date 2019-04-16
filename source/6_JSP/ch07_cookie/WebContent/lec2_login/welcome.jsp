<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 쿠키들을 가져와서 id쿠키가 있는지? -->
	<!-- id쿠키가 있으면 로그아웃버튼과 aaa(id쿠키값)님 어서오세요 msg -->
	<!-- id쿠키가 없스면 로그인버튼과 방문자님 로그인하세요 msg -->
	<%
		String id = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0 ; i<cookies.length ; i++){
				if(cookies[i].getName().equals("id")){
					id = cookies[i].getValue();
					break;
				}
			}
		}
		if(id!=null){ // id 쿠키가 있다 == 로그인 후
	%>	<button onclick="location.href='logout.jsp'">로그아웃</button>
			<hr>
			<h2><%=id %>님 어서오세요. 로그인 되었습니다</h2>	
	<%}else{ // id 쿠키가 없다 = 로그인 전 %>
			<button onclick="location.href='login.html'">로그인</button>
			<hr>
			<h2>방문자님 어서오세요. 로그인이 필요합니다</h2>
	<%	}	%>
</body>
</html>

















