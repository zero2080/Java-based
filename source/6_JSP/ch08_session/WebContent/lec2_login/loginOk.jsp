<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String id, pw, msg="";
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa")){ // id가 바른 경우
			if(pw!=null && pw.equals("111")){ // id, pw가 바른 경우
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				response.sendRedirect("welcome.jsp");
			}else{ // id는 바르고, pw가 바르지 않은 경우
				msg = "pw를 확인하세요";
			}
		}else{ // id가 바르지 않은 경우
			//msg를 login 화면에 뿌릴경우
			//msg = URLEncoder.encode("id를 확인하세요","utf-8"); 
			msg = "id를 확인하세요"; // msg를 alert에 뿌릴 경우
		}
	%>
	<script>
		alert('<%=msg%>');
		location.href = 'login.jsp';
	</script>
</body>
</html>


















