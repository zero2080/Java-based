<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if("aaa".equals(id) && "111".equals(pw)){
			Cookie cookieID = new Cookie("id",id);
			cookieID.setMaxAge(-1); // 유효시간은 브라우저 닫을 때까지
			response.addCookie(cookieID);
			Cookie cookiePW = new Cookie("pw", pw);
			cookiePW.setMaxAge(-1);
			response.addCookie(cookiePW);
			response.sendRedirect("welcome.jsp");
		}else{
	%>
			<script>
				alert('아이디와 비밀번호를 확인하세요');
				//history.back();	
				location.href='login.html';
			</script>
	<%}%>
</body>
</html>



















