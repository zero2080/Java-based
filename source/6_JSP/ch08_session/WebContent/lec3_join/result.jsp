<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String msg = request.getParameter("msg"); 
		if(msg.equals("가입이 완료되었습니다")){ // 가입성공
			out.print("<h2>"+msg+"</h2><br>");
			out.print("<a href='../lec2_login/login.jsp'>로그인</a>");
		}else{ // 가입실패
			out.println("<h2>"+msg+"</h2>");
			out.println("<a href='join.html'>회원가입</a>");
		}
	%>
</body>
</html>



















