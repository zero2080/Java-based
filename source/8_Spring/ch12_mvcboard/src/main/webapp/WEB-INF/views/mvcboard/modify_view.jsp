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
	<form action="${conPath }/modify.do" method="post">
		<input type="hidden" name="pageNum" value="${param.pageNum }">
		<input type="hidden" name="bid" value="${modify_view.bid }">
		<table>
			<caption>${modify_view.bid }번 글 수정</caption>
			<tr><th>작성자</th>
					<td><input type="text" name="bname" required="required" size="30"
								value="${modify_view.bname }"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="btitle" required="required" size="30"
								value="${modify_view.btitle }"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="32" 
							name="bcontent">${modify_view.bcontent }</textarea></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="목록" 
							onclick="location='${conPath}/list.do?pageNum=${param.pageNum }'">
						<input type="reset" value="취소"
						  onclick="history.back()">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>