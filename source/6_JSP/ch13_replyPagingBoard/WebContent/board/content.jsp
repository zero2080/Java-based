<%@page import="com.tj.dto.BoardDto"%>
<%@page import="com.tj.dao.BoardDao"%>
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
	<%String pageNum = request.getParameter("pageNum"); // pageNum추가
		BoardDao bDao = BoardDao.getInstance();
		//int i_num = Integer.parseInt(request.getParameter("num"));
		//BoardDto dto  = bDao.getBoardOneLine(i_num);
		String num = request.getParameter("num");
		bDao.readCountUp(num);
		BoardDto dto = bDao.getBoardOneLine(num);
	%>
	<table>
		<caption>게시판</caption>
		<tr><th>글번호</th><td><%=dto.getNum() %></td></tr>
		<tr><th>제목</th>  <td><%=dto.getSubject() %></td></tr>
		<tr><th>작성자</th><td><%=dto.getWriter()%></td></tr>
		<tr><th>이메일</th><td><%=dto.getEmail()%></td></tr>
		<tr><th>본문내용</th><td><pre><%=dto.getContent() %></pre></td></tr>
		<tr><th>작성일</th><td><%=dto.getrDate() %></td></tr>
		<tr><th>조회수</th><td><%=dto.getReadCount() %></td></tr>
		<tr><th>IP</th>    <td><%=dto.getIp() %></td></tr>
		<tr><td colspan="2">
					<button onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">목록</button>
					<button onclick="location.href='updateForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">수정</button>
					<button onclick="location.href='deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">삭제</button>
					<button onclick="location.href='writeForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">답변</button>
	</table>
</body>
</html>










