<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<%
	String pw = (String)session.getAttribute("pw");
	if(pw!=null){
		response.sendRedirect("welcome.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<table>
			<caption>로그인 폼</caption>
			<tr><th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id"
								required="required" autofocus="autofocus"
								value="<%
									String id = (String)session.getAttribute("id");
									if(id!=null){
										out.print(id);
									}
								%>"></td>
			</tr>
			<tr><th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw"
								required="required"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="로그인">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>












