<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dto.BoardDto"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%
		BoardDao bDao = BoardDao.getInstance();
		out.print("<h2>글갯수 : "+bDao.getBoardTotalCnt()+"</h2>");
		BoardDto dto = new BoardDto(0, "홍길동", "제목", "본문", null, 0, "11",
					0, 0, 0, "192.168.10.151", null);
		int result = bDao.insertBoard(dto);
		out.print((result == BoardDao.SUCCESS? "글쓰기성공":"글쓰기실패")+"<br>");
		result = bDao.insertBoard(dto);
		out.print((result == BoardDao.SUCCESS? "글쓰기성공":"글쓰기실패")+"<br>");
		ArrayList<BoardDto> dtos = bDao.listBoard();
		for(int i=0 ; i<dtos.size() ; i++){
			out.print(dtos.get(i).toString()+"<br>");
		}
		dto.setNum(1);
		dto.setContent("xxxxxx"); dto.setWriter("xxxxxx"); dto.setSubject("xxxx");
		result = bDao.updateBoard(dto);
		out.print((result==BoardDao.SUCCESS? "수정성공":"수정실패")+"<br>");
		result = bDao.deleteBoard(2, "11");
		out.print((result==BoardDao.FAIL? "비번틀려못지워":"삭제성공"));
		
		out.print("<hr><h2>마지막으로 전부 뿌리기</h2>");
		dtos = bDao.listBoard();
		for(int i=0 ; i<dtos.size() ; i++){
			out.print(dtos.get(i).toString()+"<br>");
		}
	%>
	<a href="x.jsp">404예외 일부러 발생</a>
</body>
</html>