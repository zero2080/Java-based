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
		width: 800px; height:370px;
		margin: 130px auto 0px;
	}
	#content td{padding:10px 20px;}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<c:if test="${not empty resultMsg }">
		<script>alert('${resultMsg}');</script>
	</c:if>
	<c:if test="${not empty errorMsg }">
		<script>
			alert('${errorMsg}');
			history.back();
		</script>
	</c:if>
	<form action="${conPath}/login.do" method="post">
		<table style="width: 50%;">
			<caption>사용자 로그인</caption>
			<tr><th>ID</th>
				<td><input type="text" name="mId" value="${mId }"
				 required="required" autofocus="autofocus"></td>
			</tr>
			<tr><th>PW</th>
				<td><input type="password" name="mPw" required="required"></td>
			</tr>
			<tr><td colspan="2">
				<input type="submit" value="로그인">
				<input type="button" value="회원가입" onclick="location='${conPath}/joinView.do'">
				</td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>