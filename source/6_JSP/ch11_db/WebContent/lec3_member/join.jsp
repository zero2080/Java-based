<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="<%=conPath %>/JoinOk" method="post">
		<table>
			<caption>회원가입</caption>
			<tr><th>이름</th>
					<td><input type="text" name="name" required="required" size="20"></td>
			</tr>
			<tr><th>아이디</th>
					<td><input type="text" name="id" required="required" size="20"></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="pw" required="required" size="20"></td>
			</tr>
			<tr><th>전화번호</th>
					<td><select name="phone1">
								<option>02</option>
								<option>010</option>
							</select> - 
							<input type="text" name="phone2" size="2"> -
							<input type="text" name="phone3" size="2">
					</td>
			</tr>
			<tr><th>성별</th>
					<td><input type="radio" name="gender" value="남" 
								checked="checked">남
							<input type="radio" name="gender" value="여">여
					</td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="가입">
						<input type="reset" value="취소">
						<input type="button" value="로그인" 
									onclick="location.href='login.jsp'">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>


















