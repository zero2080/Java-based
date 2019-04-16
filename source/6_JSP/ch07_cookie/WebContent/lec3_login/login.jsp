<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>th, td{padding:5px 10px;}</style>
</head>
<body>
	<form action="loginOk.jsp" method="post">
		<table>
			<tr><th>아이디</th><td><input type="text" name="id" value="<%
				String id = request.getParameter("id");
				if(id!=null){
					out.print(id);
				}
			%>"></td></tr>
			<tr><th>비번</th><td><input type="password" name="pw"></td></tr>
			<tr><th colspan="2"><input type="submit" value="로그인"></th></tr>
		</table>
	</form>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println("<p>"+msg+"</p>");
		}
	%>	
</body>
</html>




