<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	String msg = request.getParameter("msg");
	String validMem = (String)session.getAttribute("validMem");
	if(validMem!=null){
		response.sendRedirect("loginResult.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
	<script>
		if('<%=msg%>'=='idPwCheck'){
			alert('<%=msg%>');
		}
	</script>
</head>
<body>
	<form action="<%=conPath %>/LoginOk" method="post">
		<table>
			<tr><th>아이디</th>
					<td><input type="text" name="id" required="required"
							value="<%
								String id = (String)session.getAttribute("id");
								if(id!=null) out.print(id);
							%>"
					></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="로그인">
						<input type="button" value="회원가입"
							onclick="location.href='join.jsp'">
		</table>
	</form>
	<%--
		String msg = request.getParameter("msg");
		if(msg!=null){
			out.println("<p>"+msg+"</p>");
		}
	--%>
</body>
</html>












