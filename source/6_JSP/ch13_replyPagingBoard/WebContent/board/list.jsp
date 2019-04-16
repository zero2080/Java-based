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
		<tr><td>
		<%if(session.getAttribute("validMember")!=null){ %>
			<a href="writeForm.jsp">글쓰기	</a>
		<%} %></td></tr>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>제목</th><th>메일</th>
				<th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
		<%
			final int PAGESIZE=10;  // 한페이지당 보일 글 갯수
			final int BLOCKSIZE=10; // 한페이지당 보일 페이지 갯수
			String pageNum = request.getParameter("pageNum"); 
			if(pageNum==null){// list.jsp -> list.jsp?pageNum=1
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage-1)*PAGESIZE + 1; // 시작행
			int endRow = startRow + PAGESIZE - 1;        // 끝행
			
			BoardDao bDao = BoardDao.getInstance();
			ArrayList<BoardDto> dtos = bDao.listBoard(startRow, endRow);
			if(dtos.size()==0){
				out.print("<tr><td colspan='7'>글이 없습니다</td></tr>");
			}else{
				for(BoardDto d : dtos){
					out.print("<tr><td>"+d.getNum()+"</td><td>"+d.getWriter()+"</td>");
					out.print("<td class='left'>");
					if(d.getRe_level()>0){
						int width = d.getRe_level()*10;//level.gif의 width
						out.print("<img src='../img/level.gif' height='10' width='"+width+"'>");
						out.print("<img src='../img/re.gif'>");
					}
					if(d.getReadCount()>10){
						out.print("<img src='../img/hot.gif'>");
					}
					out.print("<a href='content.jsp?num="+d.getNum()+"&pageNum="+pageNum+"'>"
																					+d.getSubject()+"</a></td>");
					out.print("<td>"+d.getEmail()+"</td><td>"+d.getIp()+"</td>");
					out.print("<td>"+d.getrDate()+"</td><td>"+d.getReadCount()+"</td></tr>");
				}
			}
		%>
	</table>
	<div class="paging">
	<%
		int totCnt = bDao.getBoardTotalCnt(); // 전체글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);// 전체페이지갯수
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt){
			endPage = pageCnt;
		}
		if(startPage > BLOCKSIZE ){
			out.print(" [ <a href='list.jsp?pageNum="+(startPage-1)+"'>이전</a> ] ");
		}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <span class='currentPage'>" +i +"</span> ] ");
			}else{
				out.print(" [ <a href='list.jsp?pageNum="+i+"'>"+ i+"</a> ]");
			}
		}
		if(endPage<pageCnt){
			out.print(" [ <a href='list.jsp?pageNum="+(endPage+1)+"'>다음</a> ] ");
		}
	%>
	</div>
</body>
</html>