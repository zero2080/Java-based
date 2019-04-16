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
	<form action="writePro.jsp" method="post">
		<table>
			<caption>게시판글쓰기</caption>
			<tr><th>제목</th>
					<td><input type="text" name="subject" size="30" required="required"
								autofocus="autofocus"></td>
			</tr>
			<tr><th>작성자</th>
					<td><input type="text" name="writer" size="30" required="required"></td>
			</tr>
			<tr><th>이메일</th>
					<td><input type="email" name="email" size="30"></td>
			</tr>
			<tr><th>본문내용</th>
					<td><textarea rows="10" cols="32" name="content" 
									required="required"></textarea></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" size="30" required="required"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록" onclick="location='list.jsp'">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>