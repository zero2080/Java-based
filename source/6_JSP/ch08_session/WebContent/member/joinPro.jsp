<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");
		String id   = request.getParameter("id");
		session.setAttribute("id", id);
		String conPath = request.getContextPath();
		response.sendRedirect(conPath+"/member/login.jsp");
	%>
</body>
</html>