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
	<h1>5_param.jsp 파일입니다</h1>
	<h2>param : <%=request.getParameter("param") %></h2>
	<h2>id : <%=request.getParameter("id") %></h2>
	<h2>pw : <%=request.getParameter("pw") %></h2>
</body>
</html>