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
	<%String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		String pw = request.getParameter("pw");
		BoardDao bDao = BoardDao.getInstance();
		int result = bDao.deleteBoard(num, pw);
		if(result==BoardDao.SUCCESS){
			
			int totCnt = bDao.getBoardTotalCnt(); // 전체글갯수
			int pageCnt = (int)Math.ceil((double)totCnt/10);//페이지전체갯수
			int current = Integer.parseInt(pageNum);
			if(current>pageCnt)
				pageNum = String.valueOf(current-1);
	%>		
			<script>
				alert('삭제 성공');
				location.href='list.jsp?pageNum=<%=pageNum%>';
			</script>
	<%}else{%>
			<script>
				alert('삭제 실패');
				location.href = 'deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>';
			</script>
	<%}	%>
</body>
</html>






