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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#mIdConfirm').click(function(){
			var mId = $('input[name="mId"]').val();
			$.ajax({
				url : '${conPath}/mIdConfirm.do',
				type : 'get',
				dataType : 'html',
				data : "mId="+mId,
				success : function(data){
					$('#idConfirmMsg').html("<b>"+data+"</b>");
				}
			});//ajax
		});//mIdConfirm의 click이벤트
		
		$('input[name="pwChk"]').keyup(function(){
			if($('input[name="mPw"]').val() ==
					$('input[name="pwChk"]').val()){
				$('#pwChkMsg').html('<b>비밀번호 일치</b>');
			}else{
				$('#pwChkMsg').html('<b>비밀번호 불일치</b>');
			}//if
		});//input[name="pwChk"]의 keyup이벤트
		
	});
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
				<td><input type="text" name="mId" required="required">
						<input type="button" id="mIdConfirm" value="중복체크"><br>
						<div id="idConfirmMsg"> &nbsp; &nbsp; &nbsp; </div>
				</td>
		</tr>
		<tr><th>비밀번호</th>
				<td><input type="password" name="mPw" required="required"></td>
		</tr>
		<tr><th>비번확인</th>
				<td><input type="password" name="pwChk" required="required"><br>
						<div id="pwChkMsg"> &nbsp; &nbsp; &nbsp; </div>
				</td>
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