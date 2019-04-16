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
	<h1>2_forward.jsp파일입니다</h1>
	<h2>전달받은 파라미터 param : <%=request.getParameter("param") %></h2>
</body>
</html>





