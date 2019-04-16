<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String result = request.getParameter("result");
		if(result.equals("ok")){ // 회원가입성공
	%>
			<h2>회원가입이 정상처리되었습니다. 환영합니다</h2>
			<button onclick="location='login.jsp'">로그인</button>
	<%	}else{ // 회원가입 실패%>
			<h2>회원가입이 처리되지 못했습니다</h2>
			<button onclick="location='join.jsp'">회원가입</button>
			<button onclick="location='login.jsp'">로그인</button>
	<%	}	%>
</body>
</html>



















