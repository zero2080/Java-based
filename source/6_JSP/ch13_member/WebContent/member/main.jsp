<%@page import="com.tj.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("validMember")==null){
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
	%>
	<%--
		MemberDto dto = (MemberDto)session.getAttribute("member");
		String id="", name="";
		if(dto!=null){
			id= dto.getId(); name = dto.getName();
		}
	--%>
	<h2><%=name %>(<%=id %>)님 어서오세요</h2>
	<hr>
	<form action="modify.jsp">
		<input type="submit" value="정보수정">
		<input type="button" value="로그아웃" onclick="location='logout.jsp'">
	</form>
</body>
</html>