<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.model1ex.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
	<style>
		#content {
			width: 800px; height:400px;
			margin: 100px auto 0px;
		}
		.help{font-weight: bold; color:blue;display: none;}
		td:hover .help { display: block; position: absolute;
				transform: rotate(315deg);
		}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<%
		//listBook.jsp
		//listBook.jsp?pageNum=2
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=3, BLOCKSIZE=5;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow   = startRow + PAGESIZE -1;
		BookDao bDao = BookDao.getInstance();
		ArrayList<BookDto> dtos = bDao.listBook(startRow, endRow);
	%>
	<table>
		<tr>
			<%for(BookDto d : dtos) {%>
					<td>
						<a href="bookContent.jsp?bid=<%=d.getBid()%>">
						<img src="../bookImg/<%=d.getBimage1() %>" width="200" 
							alt="<%=d.getBtitle() %> 이미지"><br>
						<%=d.getBtitle() %><br>
						<del><%=d.getBprice() %></del><br>
						<%=(int)(d.getBprice()*(100-d.getBdiscount())*0.01) %>
						(<%=d.getBdiscount() %>%할인)
						</a>
						<div class="help">도서를 클릭하면 상세보기 페이지가 나와요</div>
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
			out.print("[ <a href='bookList.jsp?pageNum="+(startPage-1)+"'>이전</a> ]");
		}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print(" [ <span class='currentPage'>"+i+"</span> ] ");
			}else{
				out.print("[ <a href='bookList.jsp?pageNum="+i+"'>"+i+"</a> ]");
			}
		}
		if(endPage<pageCnt){
			out.print("[ <a href='bookList.jsp?pageNum="+(endPage+1)+"'>다음</a> ]");
		}
	%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>