<%@page import="com.tj.model1ex.dto.BookDto"%>
<%@page import="com.tj.model1ex.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
	<style>
		#content {
			width: 800px; height:415px;
			margin: 40px auto;
		}
		table td {padding: 10px;}
	</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<%
		int bid = Integer.parseInt(request.getParameter("bid"));
		BookDao bDao = BookDao.getInstance();
		BookDto bDto = bDao.getBookOne(bid);
	%>
		<table style="width: 70%;">
			<tr><td rowspan="4"><img src="<%=conPath%>/bookImg/<%=bDto.getBimage1() %>" alt="image1" width="150" height="150"></td>
					<td><%=bDto.getBid() %>번 도서 상세보기</td>
			</tr>
			<tr><td><%=bDto.getBtitle() %></td></tr>
			<tr><td style="font-weight: blod; font-size: 1.2em;">
						<del><%=bDto.getBprice() %>원</del><br>
						<%=(int)(bDto.getBprice()*(100-bDto.getBdiscount())*0.01) %>원<br>
						<%=bDto.getBdiscount() %> %할인
					
					</td>
			</tr>
			<tr><td>
						<input type="button" value="장바구니">
						<input type="button" value="구매하기">
					</td>
			</tr>
			<tr><td colspan="2">
						<img src="<%=conPath%>/bookImg/<%=bDto.getBimage2() %>" alt="image2" width="200" height="150">
						<pre><%=bDto.getBcontent() %></pre>
					</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>