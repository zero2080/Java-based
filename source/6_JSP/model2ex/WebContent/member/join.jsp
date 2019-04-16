<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:400px;
		margin: 100px auto 0px;
	}
</style>
<script>
	function joinInfoChk(){
		if(joinFrm.mPw.value!=joinFrm.pwChk.value){
			alert('비밀번호가 일치해야 합니다');
			joinFrm.mPw.value = '';
			joinFrm.pwChk.value = '';
			joinFrm.mPw.focus();
			return false;
		}
	}
</script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<form action="${conPath}/join.do" method="post"
		enctype="multipart/form-data" name="joinFrm"
		onsubmit="return joinInfoChk()">
	<table>
		<caption>회원가입</caption>
		<tr><th>아이디</th>
				<td><input type="text" name="mId" required="required"></td>
		</tr>
		<tr><th>비밀번호</th>
				<td><input type="password" name="mPw" required="required"></td>
		</tr>
		<tr><th>비번확인</th>
				<td><input type="password" name="pwChk" required="required"></td>
		</tr>
		<tr><th>이름</th>
				<td><input type="text" name="mName" required="required"></td>
		</tr>
		<tr><th>메일주소</th>
				<td><input type="text" name="mEmail"></td>
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
					onclick="location='${conPath}/loginView.do'"> 
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>