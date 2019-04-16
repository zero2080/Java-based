<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		boolean isValid = false;
		if(id!=null && id.equals("aaa") 
				&& pw!=null && pw.equals("111")){
			isValid = true;
		}
		if(!isValid){
			//String msg = URLEncoder.encode("ID와 PW를 체크하세요!","utf-8");
			response.sendRedirect("07_loginFrm.jsp?msg=no");
		}
	%>
	<h2>아이디는 <%=id %></h2>
	<h2>비밀번호는 <%=pw %>입니다</h2>
	<h2>&nbsp;</h2>
	<h2>반갑습니다</h2>
</body>
</html>

















