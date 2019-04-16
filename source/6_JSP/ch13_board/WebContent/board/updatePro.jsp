<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.dto.BoardDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao boardDao = BoardDao.getInstance();
		int result = boardDao.updateBoard(dto);
		if(result == BoardDao.SUCCESS){
	%>
			<script>
				alert('수정 성공');
				location.href='list.jsp';
			</script>	
	<%}else if(result == BoardDao.FAIL){%>
			<script>
				alert('수정 실패');
				history.go(-1);
			</script>
	<%}	%>
</body>
</html>