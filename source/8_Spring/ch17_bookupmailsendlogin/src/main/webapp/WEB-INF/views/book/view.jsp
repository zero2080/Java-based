<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 50px auto;
	}
	img{width: 100px;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<caption>도서 LIST</caption>
			<tr>
			<c:forEach var="book" items="${view }">
				<td>
					${book.btitle }<br>
					<a href="${conPath }/book.do?method=detail&bnum=${book.bnum}&pageNum=${paging.currentPage}">
					<img src="${conPath }/bookImgFileUpload/${book.bimg1}"></a><br>
					${book.bwriter } 著 <br>
					출판일 : ${book.brdate }
				</td>
			</c:forEach>
			</tr>
		</table>
	
	<div>
	<c:if test="${paging.startPage>paging.blockSize}">
		[ <a href="${conPath }/book.do?method=view&pageNum=${paging.startPage+1 }">이전</a> ]
	</c:if>	
	<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage }">
		<c:if test="${paging.currentPage==i }"> 
			<b>[ ${i } ]</b> 
		</c:if>
		<c:if test="${paging.currentPage != i }">
			[ <a href="${conPath }/book.do?method=view&pageNum=${i }">${i }</a> ]
		</c:if>
	</c:forEach>
	<c:if test="${paging.endPage<paging.pageCnt }">
		[ <a href="${conPath }/book.do?method=view&pageNum=${paging.endPage+1 }">다음</a> ]
	</c:if>
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>