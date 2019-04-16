<%@page import="com.tj.dao.BoardDao"%>
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
		int num = Integer.parseInt(request.getParameter("num"));
		String pw = request.getParameter("pw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(num, pw);
		if(result==BoardDao.SUCCESS){
	%>		
			<script>
				alert('삭제 성공');
				location.href='list.jsp';
			</script>
	<%}else{%>
			<script>
				alert('삭제 실패');
				history.back();
			</script>
	<%}	%>
</body>
</html>