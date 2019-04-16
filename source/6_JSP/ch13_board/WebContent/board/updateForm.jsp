<%@page import="com.tj.dao.BoardDao"%>
<%@page import="com.tj.dto.BoardDto"%>
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
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bDao = BoardDao.getInstance();	
		BoardDto dto = bDao.getBoardOneLine(num); 
	%>
	<form action="updatePro.jsp" method="post">
		<input type="hidden" name="num" value="<%=num%>">
		<table>
			<caption>글 수정하기</caption>
			<tr><th>글번호</th>
					<td><%=num %></td>
			</tr>
			<tr><th>제목</th>
					<td><input type="text" name="subject" size="30" required="required"
								autofocus="autofocus" value="<%
								if(dto!=null) out.print(dto.getSubject());
								%>"></td>
			</tr>
			<tr><th>작성자</th>
					<td><input type="text" name="writer" size="30" required="required"
								value="<%=dto.getWriter()%>"></td>
			</tr>
			<tr><th>이메일</th>
					<td><input type="email" name="email" size="30" 
								value="<%=dto.getEmail()%>"></td>
			</tr>
			<tr><th>본문내용</th>
					<td><textarea rows="10" cols="32" name="content" 
									required="required"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" size="30" required="required"
									value="<%=dto.getPw()%>"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="수정하기">
						<input type="reset" value="수정취소" onclick="history.back()">
						<input type="button" value="목록" onclick="location='list.jsp'">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>