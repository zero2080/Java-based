<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		header {width:1000px; margin: 0 auto; border: 1px solid red; }
		header #nav ul {overflow: hidden;}
		header #nav ul li{
			float: right; list-style: none; padding:10px;
		}
		header #nav ul li a {text-decoration: none;}
	</style>
</head>
<body>
	<header>
		<div id="nav">
			<%
				String id = null;
				Cookie[] cs = request.getCookies();
				if(cs!=null){
					for(Cookie c : cs){
						if(c.getName().equals("id")){ // id라는 이름의 쿠키가 있느지?
							id = c.getValue();
							break;
						}
					}
				}
				if(id!=null){ //로그인 후 (로그아웃, 정보수정, aaa님)
			%>
					<ul>
						<li><a href="logout.jsp">로그아웃</a></li>
						<li><a href="modify.jsp">정보수정</a></li>
						<li><a href="#"><%=id %>님</a>
					</ul>
			<%}else{ 				//로그인 이전(회원가입, 로그인, 홈)%>
					<ul>
						<li><a href="join.jsp">회원가입</a></li>
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="main.jsp">홈</a></li>
					</ul>
			<%}	%>
		</div>
	</header>	
</body>
</html>













