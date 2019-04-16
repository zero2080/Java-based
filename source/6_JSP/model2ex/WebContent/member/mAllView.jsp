<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
body {font-size: 9pt; }
#content table{width:70%; margin: 30px auto;}
#content td { text-align: center; padding: 20px;}
#content caption { font-size: 1.3em; text-align: center;}
#content div { text-align: center; }
#content span.currentPage{color:red; font-weight: bold;}
#content a {text-decoration: none;}
</style>
<style>
	#content {
		width: 800px; height:450px;
		margin: 50px auto 0px;
	}
</style>
</head>
<body>
<c:if test="${not empty adminLoginResult }">
	<script>
		alert('${adminLoginResult}');
	</script>
</c:if>
<c:if test="${not empty adminLoginError }">
	<script>
		history.back();
	</script>
</c:if>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<table>
		<caption>전체회원보기</caption>
		<tr>
			<c:forEach var="member" items="${mAllView }">
				<td>
					<img src="${conPath }/mPhotoUp/${member.mPhoto}" width="150"><br>
					${member.mName}<br>
					(${member.mId})
				</td>
			</c:forEach>
		</tr>
	</table>
	<div class="paging">
		<a href="${conPath }/allView.do?pageNum=1"> &lt;&lt; </a>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage>BLOCKSIZE }">
			<a href="${conPath }/allView.do?pageNum=${startPage-1 }"> &lt; </a>
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${startPage<=BLOCKSIZE }">
			&lt;
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i==pageNum }">
				<span class="currentPage">[ ${i} ]</span>
			</c:if>
			<c:if test="${i!=pageNum }">
				[ <a href="${conPath }/allView.do?pageNum=${i }">${i }</a> ]
			</c:if>
		</c:forEach>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage<pageCnt }">
			<a href="${conPath }/allView.do?pageNum=${endPage+1 }"> &gt; </a> 
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<c:if test="${endPage==pageCnt }">
			&gt; 
		</c:if>
		&nbsp; &nbsp; &nbsp;
		<a href="${conPath }/allView.do?pageNum=${pageCnt}"> &gt;&gt; </a>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>