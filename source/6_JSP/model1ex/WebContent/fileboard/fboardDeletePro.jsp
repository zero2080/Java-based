<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String pageNum = request.getParameter("pageNum");
	String fpw = request.getParameter("fpw");
	int fnum = Integer.parseInt(request.getParameter("fnum").trim());
	FileBoardDao fbDao = FileBoardDao.getInstance();
	int result = fbDao.deleteFileBoard(fnum, fpw);
	if(result==FileBoardDao.SUCCESS){
		response.sendRedirect("fboardList.jsp?pageNum="+pageNum);
	}else{%>
		<script>
			alert('비밀번호가 맞지 않으면 삭제되지 않아요');
			location.href='fboardContent.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>';
		</script>
<%	}%>
</body>
</html>