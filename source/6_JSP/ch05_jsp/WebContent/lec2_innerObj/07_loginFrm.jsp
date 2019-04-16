<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{width:300px; margin: 20px auto;}
	table tr td {padding:5px;}
	h2 {width:300px; margin: 0 auto; text-align: center; color:red;}
</style>
</head>
<body>
	<form action="07_loginCertification.jsp" method="post">
		<table>
			<tr><th>아이디</th>
					<td><input type="text" name="id" required="required"
									autofocus="autofocus"></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr><th colspan="2">
						<input type="submit" value="로그인">
					</th>
			</tr>
		</table>
	</form>
	<%String msg = request.getParameter("msg");
		if(msg!=null && msg.equals("no")){
			out.println("<h2>ID와 PW 체크하세요</h2>");
		}
	%>
</body>
</html>



















