<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전있는 곳을 맞춰봐</title>
<style>
	#wrap {width:250px; margin: 30px auto;}
	p {text-align: center;}
	p:last-child { color:red;}
</style>
</head>
<body>
	<div id="wrap">
	<%
		int su = Integer.parseInt(request.getParameter("su"));
		//int comSu = (int)(Math.random()*3)+1;
		Random random = new Random();
		int comSu = random.nextInt(3)+1;
		if(su!=comSu){
			String msg = URLEncoder.encode("Wrong! Try Again!<br>(틀렸어! 다시 해봐!)","utf-8");
			response.sendRedirect("08_yaba.jsp?msg="+msg);
		}
	%>
	<p>당신이 찍은 곳은 <%=su %>번이고 랜덤으로 선택된 동전있는 곳도 <%=comSu %></p>
	<p>정답</p> 
	</div>
</body>
</html>