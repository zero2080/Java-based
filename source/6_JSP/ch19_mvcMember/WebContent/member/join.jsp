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
	<script>
		function chk(){
			if(frm.mPw.value != frm.mPwChk.value){
				alert('비번을 확인하세요');
				frm.mPw.value = '';
				frm.mPwChk.value = '';
				frm.mPw.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<form action="${conPath }/join.do" method="post" 
						enctype="multipart/form-data" name="frm" onsubmit="return chk()">
		<table>
			<caption>회원가입</caption>
			<tr><th>아이디</th>
					<td><input type="text" name="mId" required="required"></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="mPw" required="required"></td>
			</tr>
			<tr><th>비밀번호</th>
					<td><input type="password" name="mPwChk" required="required"></td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="mName" required="required"></td>
			</tr>
			<tr><th>메일</th>
					<td><input type="email" name="mEmail"></td>
			</tr>
			<tr><th>사진</th>
					<td><input type="file" name="mPhoto"></td>
			</tr>
			<tr><th>생년월일</th>
					<td><input type="date" name="mBirth"></td>
			</tr>
			<tr><th>주소</th>
					<td><input type="text" name="mAddress"></td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="회원가입">
						<input type="button" value="로그인"
							onclick="location.href='${conPath}/loginView.do'">
		</table>
	</form>
</body>
</html>