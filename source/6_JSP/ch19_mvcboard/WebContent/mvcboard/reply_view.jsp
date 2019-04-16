<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- 넘어온 파라미터 : pageNum, bid -->
	<!-- requestScope.reply_view (dto) -->
	<form action="${conPath }/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bgroup" value="${reply_view.bgroup }">
		<input type="hidden" name="bstep" value="${reply_view.bstep }">
		<input type="hidden" name="bindent" value="${reply_view.bindent }"> 
		<table>
			<caption>${reply_view.bid }번 글의 답변 쓰기</caption>
			<tr><th>작성자</th>
					<td><input type="text" name="bname" required="required" size="30"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="btitle" size="30" required="required"
								value="[답]${reply_view.btitle.substring(0,1) }"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="32" name="bcontent"></textarea></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="답변저장">
						<input type="reset" value="취소">
						<input type="reset" value="이전" onclick="history.go(-1)">
						<input type="button" value="목록" 
							onclick="location='${conPath}/list.do?pageNum=${param.pageNum}'">
		</table>
	</form>
</body>
</html>