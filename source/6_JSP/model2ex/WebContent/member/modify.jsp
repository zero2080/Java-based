<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:400px;
		margin: 100px auto 0px;
	}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<form action="${conPath}/modify.do" method="post"
		enctype="multipart/form-data" name="frm">
	<input type="hidden" name="dbmPhoto" value="${member.mPhoto}">
	<table>
		<caption>회원정보수정</caption>
		<tr><th>아이디</th>
			<td><input type="text" name="mId" value="${member.mId }" readonly="readonly"></td>
			<td rowspan="3">
			<img src="${conPath}/mPhotoUp/${member.mPhoto}" height="100"></td>
		</tr>
		<tr><th>비밀번호</th>
			<td><input type="password" name="mPw" value="${member.mPw }"></td>
		</tr>
		<tr><th>이름</th>
			<td><input type="text" name="mName" value="${member.mName }"></td>
		</tr>
		<tr><th>메일주소</th>
			<td colspan="2"><input type="email" name="mEmail" value="${member.mEmail }"></td>
		</tr>
		<tr><th>사진</th>
			<td colspan="2"><input type="file" name="mPhoto"></td>
		</tr>
		<tr><th>생년월일</th>
				<td colspan="2"><input type="date" name="mBirth" value="${member.mBirth}" ></td>
		</tr>
		<tr><th>주소</th>
			<td colspan="2"><input type="text" name="mAddress" value="${member.mAddress }"></td>
		</tr>
		<tr><td colspan="3">
				<input type="submit" value="정보수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>