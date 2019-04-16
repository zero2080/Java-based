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
		int num=0, ref=0, re_step=0, re_level=0;
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum = "1";
		BoardDto dto = new  BoardDto();
		if(request.getParameter("num")!=null){ // 답변글이군
			num = Integer.parseInt(request.getParameter("num"));
			BoardDao dao = BoardDao.getInstance();
			dto = dao.getBoardOneLine(num);
			ref = dto.getRef();
			re_step = dto.getRe_step();
			re_level = dto.getRe_level();
			System.out.print(num+"번 글 답변 예정 / step:"+re_step+"/level:"+re_level);
		}
	%>

	<form action="writePro.jsp" method="post">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="ref" value="<%=ref%>">
		<input type="hidden" name="re_step" value="<%=re_step%>">
		<input type="hidden" name="re_level" value="<%=re_level%>">
		<table>
			<caption>게시판글쓰기</caption>
			<tr><th>제목</th>
					<td><input type="text" name="subject" size="30" required="required"
								autofocus="autofocus"
								value="<%
								if(num>0) out.print("[답]"+dto.getSubject().substring(0,1));
								%>"></td>
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