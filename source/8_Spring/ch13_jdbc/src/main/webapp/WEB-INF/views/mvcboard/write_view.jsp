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
	<form action="${conPath }/write.do" method="post">
		<table>
			<caption>글쓰기</caption>
			<tr><th>작성자</th>
					<td><input type="text" name="bname" required="required" size="30"></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="btitle" required="required" size="30"></td>
			</tr>
			<tr><th>본문</th>
					<td><textarea rows="5" cols="32" name="bcontent"></textarea></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="글쓰기">
						<input type="reset" value="취소">
						<input type="button" value="목록"
								onclick="location.href='${conPath}/list.do'">
		</table>
	</form>
</body>
</html>