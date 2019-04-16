<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa") && pw!=null && pw.equals("111")){
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("login.jsp?msg=x");
		}
	%>
</body>
</html>









