<%@page import="com.tj.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<c:set var="SUCCESS" value="1"/>
	<c:set var="FAIL" value="0"/>
	<c:if test="${writeResult == SUCCESS }">
		<script>alert("글쓰기 성공");</script>
	</c:if>
	<c:if test="${writeResult == FAIL }">
		<script>alert("글쓰기 실패");</script>
	</c:if>
	<c:if test="${modifyResult == SUCCESS }">
		<script>alert("글수정 성공");</script>
	</c:if>
	<c:if test="${modifyResult == FAIL }">
		<script>alert("글수정 실패");</script>
	</c:if>
	<c:if test="${deleteResult == SUCCESS }">
		<script>alert("글삭제 성공");</script>
	</c:if>
	<c:if test="${deleteResult == FAIL }">
		<script>alert("글삭제 실패");</script>
	</c:if>
	<c:if test="${replyResult == SUCCESS }">
		<script>alert("답변달기 성공");</script>
	</c:if>
	<c:if test="${replyResult == FAIL }">
		<script>alert("답변달기 실패");</script>
	</c:if>
	
	<table>
		<tr><td><a href="${conPath }/write_view.do">글쓰기</a>
	</table>
	<table>
		<tr><th>글번호</th><th>작성자</th><th>글제목</th><th>작성일</th>
				<th>조회수</th>
		</tr>
		<c:if test="${totCnt == 0 }">
			<tr><td colspan="5">글이 없습니다</td></tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach var="dto" items="${list }">
				<tr><td>${dto.bid }</td>
						<td>${dto.bname }</td>
						<td class="left">
							<c:forEach var="i" begin="1" end="${dto.bindent }">
								<c:if test="${i == dto.bindent }">
								   └─
								</c:if>
								<c:if test="${i != dto.bindent }">
								    &nbsp; &nbsp; &nbsp; 
								</c:if>
							</c:forEach>
				<a href="${conPath }/content_view.do?bid=${dto.bid}&pageNum=${pageNum}">
							${dto.btitle }</a>
						</td>
						<td><fmt:formatDate value="${dto.bdate }" pattern="yyyy/MM/dd(E)"/></td>
						<td>${dto.bhit }</td>
					</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			<a href="${conPath }/list.do?pageNum=${startPage-1}"> 이전 </a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i == pageNum }">
				[ <b>${i }</b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/list.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="${conPath }/list.do?pageNum=${endPage+1}"> 다음 </a>
		</c:if>
	</div>
</body>
</html>