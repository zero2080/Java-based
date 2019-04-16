<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="${conPath }/js/join.js"></script>
</head>
<body>
	<form action="${conPath }/joinMember.do" method="post" name="join_frm">
		<table>
			<caption>회원가입</caption>
			<tr><th>아이디  </th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pw"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="pwChk"></td></tr>
			<tr><th>이름    </th><td><input type="text" name="name"></td></tr>
			<tr><th>메일주소</th><td><input type="text" name="email"></td></tr>
			<tr><th>생년월일</th><td><input type="date" name="birth"></td></tr>
			<tr><th>주소    </th><td><input type="text" name="address"></td></tr>
			<tr><td colspan="2">
						<input type="button" value="회원가입" onclick="joinInfoChk()">
						<input type="reset" value="취소">
						<input type="button" value="로그인" onclick="location='login.jsp'">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>