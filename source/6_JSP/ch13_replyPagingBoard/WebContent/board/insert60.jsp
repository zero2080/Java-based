<%@page import="com.tj.dto.BoardDto"%>
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
	BoardDao bDao = BoardDao.getInstance();
	BoardDto dto  = new BoardDto();
	for(int i=0 ; i<60 ; i++){
		dto.setSubject("홍길동글"+i);
		dto.setWriter("홍길동"+i);
		dto.setEmail("hong"+i+"@tj.com");
		dto.setContent("홍길동은 동에 번쩍\r\n서해번쩍");
		dto.setPw("11");
		dto.setIp(request.getRemoteAddr()); // 글쓰기필요데이터강제입력
		dto.setReadCount(i%12); // 조회수조작
		int result = bDao.insertBoard(dto);
		System.out.print(result==BoardDao.SUCCESS? i+"번째성공":i+"번째실패");
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>





















