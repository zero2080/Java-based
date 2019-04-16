<%@page import="com.tj.ex.dao.MemberDao"%>
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
		String id = request.getParameter("id");
		MemberDao mDao = new MemberDao();
		int result = mDao.mIdConfirm(id);
		if(result==MemberDao.EXISTENT){
	%>	중복된 ID입니다			
	<%}else{%>
			사용 가능한 ID입니다
	<%}%>
</body>
</html>

















