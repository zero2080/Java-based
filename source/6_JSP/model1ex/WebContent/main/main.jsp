<%@page import="com.tj.model1ex.dto.CustomerDto"%>
<%@page import="com.tj.model1ex.dao.CustomerDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:400px;
		margin: 100px auto 0px;
	}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<br><br>
	<table>
		<tr><td>회원ID</td><td>PW</td><td>이름</td><td>메일</td><td>주소</td></tr>
	<%
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		int PAGESIZE = 5, BLOCKSIZE=3;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow = startRow + PAGESIZE-1;
		CustomerDao cDao = CustomerDao.getInstance();
		ArrayList<CustomerDto> customers = cDao.getlistCustomer(startRow, endRow);
		if(customers.size()==0){
			out.print("<tr><td colspan='5'>가입한 회원이 없습니다</td></tr>");
		}else{
			for(CustomerDto c : customers){
				out.print("<tr><td>"+c.getCid()+"</td>");
				out.print("<td>"+c.getCpw()+"</td>");
				out.print("<td>"+c.getCname()+"</td>");
				out.print("<td>"+c.getCemail()+"</td>");
				out.print("<td>"+(c.getCaddr()==null? "-":c.getCaddr())+"</td></tr>");
			}//for
		}//if
	%>
	</table>
	<div class="paging">
	<%int totCnt = cDao.getCustomerCnt(); // DB에 있는 회원수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE); // 페이지갯수
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt)
			endPage = pageCnt;
		if(startPage>BLOCKSIZE){%>
			 [ <a href="main.jsp?pageNum=<%=startPage-1%>">이전</a> ]
	<%}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){%>
				[ <span class="currentPage"><%=i %></span> ]
		<%}else{ %>
				[ <a href="main.jsp?pageNum=<%=i%>"><%=i %></a> ]
		<%}
		}
		if(endPage<pageCnt){%>
			[ <a href="main.jsp?pageNum=<%=endPage+1%>">다음</a> ]
	<%}	%>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>