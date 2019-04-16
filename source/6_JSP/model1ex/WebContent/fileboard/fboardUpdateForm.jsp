<%@page import="com.tj.model1ex.dto.FileBoardDto"%>
<%@page import="com.tj.model1ex.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:400px;
		margin: 50px auto;
	}
</style>
</head>
<body>
<%	String pageNum = request.getParameter("pageNum");
	//String num = request.getParameter("num");
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	FileBoardDao fbDao = FileBoardDao.getInstance();
	FileBoardDto fbDto = fbDao.getFileBoardOneLine(fnum);
%>
<jsp:include page="../main/header.jsp"/>
<div id="content">
<form action="fboardUpdatePro.jsp" method="post"  enctype="multipart/form-data">
	<input type="hidden" name="pageNum" value="<%=pageNum%>">
	<input type="hidden" name="fnum" value="<%=fnum%>">
	<input type="hidden" name="dbfilename" value="<%=fbDto.getFfilename() %>">
	<table>
		<caption>글수정</caption>
		<tr><th>글번호</th><td><%=fnum %></td></tr>
		<tr><th>제목</th>
			<td><input type="text" name="fsubject" size="30"
				value="<%=fbDto.getFsubject() %>" required="required">
			</td>
		</tr>
		<tr><th>첨부파일</th>
			<td><input type="file" name="ffilename" size="30">
				<%
				if(fbDto.getFfilename()!=null){
					out.print(fbDto.getFfilename());
				}else{
					out.print("첨부화일없음");
				}
				%>
			</td>
		</tr>
		<tr><th>본문</th>
			<td><pre><textarea name="fcontent" rows="10" cols="32"
						required="required"
				><%=fbDto.getFcontent() %></textarea></pre>
			</td>
		</tr>
		<tr><th>삭제암호</th>
			<td><input type="password" name="fpw" size="30"
				 value="<%=fbDto.getFpw() %>"	required="required">
			</td>
		</tr>
		<tr><td colspan="2">
			 <input type="submit" value="수정저장">
			 <input type="reset"  value="수정취소">
			 <input type="button" value="이전"
			 	onclick="history.back()">
			 <input type="button" value="목록" 
			 	onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
	</table>
</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>