<%@page import="com.tj.dao.BoardDao"%>
<%@page import="com.tj.dto.BoardDto"%>
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
	<%	request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.dto.BoardDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		dto.setIp(request.getRemoteAddr());
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.insertBoard(dto);
		String pageNum = request.getParameter("pageNum");
		if(result == BoardDao.SUCCESS){
	%>	
			<script>
				alert('글쓰기 완료');
				location.href = 'list.jsp?pageNum=<%=pageNum%>';
			</script>	
	<%}else if(result == BoardDao.FAIL){%>
			<script>
				alert('글쓰기 실패');
				history.back();
			</script>
	<%}%>
</body>
</html>