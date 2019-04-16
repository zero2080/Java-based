<%@page import="java.net.URLEncoder"%>
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
		String msg = "";
		if("aaa".equals(id)){ // id는 맞게 입력
			if("111".equals(pw)){ // id와 pw를 모두 맞게 입력
				Cookie cookieID = new Cookie("id",id);
				cookieID.setMaxAge(-1); // 유효시간은 브라우저 닫을 때까지
				response.addCookie(cookieID);
				Cookie cookiePW = new Cookie("pw", pw);
				cookiePW.setMaxAge(-1);
				response.addCookie(cookiePW);
	%>
				<script>
					alert("로그인 성공"); 
					location.href='welcome.jsp';
				</script>
	<%			
			}else{ //id는 맞게. pw는 틀리게 입력
				msg = URLEncoder.encode("비밀번호를 확인하세요","utf-8");
				response.sendRedirect("login.jsp?msg="+msg+"&id="+id);
			}
		}else{ // id를 틀리게 입력
			msg = URLEncoder.encode("ID를 확인하세요","utf-8");
			response.sendRedirect("login.jsp?msg="+msg);
		}
	%>
</body>
</html>



















