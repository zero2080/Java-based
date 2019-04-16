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
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum"); 
	%>
	<table>
		<caption>글삭제</caption>
		<tr><td>
			<fieldset>
				<legend>삭제를 위한 암호가 일치하여야 합니다</legend>
				<form action="deletePro.jsp" method="post">
					<input type="hidden" name="num" value="<%=num%>">
					<input type="hidden" name="pageNum" value="<%=pageNum%>">
					<p>암호 <input type="password" name="pw" required="required"></p>
					<p><input type="submit" value="글삭제">
						 <input type="reset" value="삭제취소" onclick="history.back()"></p>
				</form>
			</fieldset>
		</td></tr>
	</table>
</body>
</html>










