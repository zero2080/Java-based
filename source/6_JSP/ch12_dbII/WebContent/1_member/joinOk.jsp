<%@page import="com.tj.dao.MemberDao"%>
<%@page import="com.tj.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String conPath = request.getContextPath();
		request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="com.tj.dto.MemberDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.memberInsert(dto);
		if(result>0){
			out.print("<h2>회원가입이 완료되었습니다</h2>");
		}else{
			out.print("<h2>회원가입이 거부되었습니다</h2>");
		}
	%>
	<hr>
	<jsp:include page="memberList.jsp"/>
	<h2><button onclick="location.href='join.jsp'">회원가입</button></h2>
</body>
</html>


















