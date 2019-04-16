<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
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
	<table>
		<caption>게시판</caption>
		<tr><td><a href="writeForm.jsp">글쓰기</a></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>메일</th>
				<th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
		<%
			BoardDao bDao = BoardDao.getInstance();
			int totCnt = bDao.getBoardTotalCnt(); // 글갯수
			if(totCnt==0){
				out.print("<tr><td colspan='7'>글이 없습니다</td></tr>");
			}else{
				ArrayList<BoardDto> dtos = bDao.listBoard();
				for(BoardDto d : dtos){
					out.print("<tr><td>"+d.getNum()+"</td><td>"+d.getWriter()+"</td>");
					out.print("<td class='left'>");
					if(d.getReadCount()>10){
						out.print("<img src='../img/hot.gif'>");
					}
					out.print("<a href='content.jsp?num="+d.getNum()+"'>"
																					+d.getSubject()+"</a></td>");
					out.print("<td>"+d.getEmail()+"</td><td>"+d.getIp()+"</td>");
					out.print("<td>"+d.getrDate()+"</td><td>"+d.getReadCount()+"</td></tr>");
				}
			}
		%>
	</table>
</body>
</html>