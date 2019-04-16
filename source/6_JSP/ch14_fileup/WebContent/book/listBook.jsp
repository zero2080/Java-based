<%@page import="com.tj.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BookDao"%>
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
	<%
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> dtos = bDao.listBook();
	%>
	<table>
		<tr>
		<%for(int i=0 ; i<dtos.size() ; i++){ %>
			<td>
				<img src="../bookImg/<%=dtos.get(i).getBimage1() %>" width="200" 
					alt="<%=dtos.get(i).getBtitle() %> 이미지">
				<br>
				<%=dtos.get(i).getBtitle() %><br>
				<del><%=dtos.get(i).getBprice() %></del><br>
				<%=dtos.get(i).getBprice()*(100-dtos.get(i).getBdiscount())*0.01 %>
				(<%=dtos.get(i).getBdiscount() %>%할인)
			</td>
			<%if(i%3 == 2){
					out.print("</tr><tr>");
				}
			%>
		<%} %>
		</tr>
	</table>
	<%
		//listBook.jsp
		//listBook.jsp?pageNum=2
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=3, BLOCKSIZE=5;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow   = startRow + PAGESIZE -1;
		dtos = bDao.listBook(startRow, endRow);
	%>
	<table>
		<tr>
			<%for(BookDto d : dtos) {%>
					<td>
						<img src="../bookImg/<%=d.getBimage1() %>" width="200" 
							alt="<%=d.getBtitle() %> 이미지"><br>
						<%=d.getBtitle() %><br>
						<del><%=d.getBprice() %></del><br>
						<%=d.getBprice()*(100-d.getBdiscount())*0.01 %>
						(<%=d.getBdiscount() %>%할인)
					</td>
			<%} %>
		</tr>
	</table>
	<div class="paging">
	<%
		int totCnt = bDao.getBookCnt(); // DB 행수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 총 페이지 수
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt){
			endPage = pageCnt;
		}
		if(startPage>BLOCKSIZE){
			out.print("[ <a href='listBook.jsp?pageNum="+(startPage-1)+"'>이전</a> ]");
		}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <span class='currentPage'>"+i+"</span> ] ");
			}else{
				out.print("[ <a href='listBook.jsp?pageNum="+i+"'>"+i+"</a> ]");
			}
		}
		if(endPage<pageCnt){
			out.print("[ <a href='listBook.jsp?pageNum="+(endPage+1)+"'>다음</a> ]");
		}
	%>
	</div>
</body>
</html>























