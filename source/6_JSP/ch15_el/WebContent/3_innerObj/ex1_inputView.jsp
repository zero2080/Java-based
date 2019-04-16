<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이름 ${param.name}</h2>
	<h2>아이디 ${param.id}</h2>
	<h2>비번 ${param.pw}</h2>
	<h2>주소 ${param.address }</h2>
	<h2>메일 ${empty param.mail}</h2>
	<hr>
	<h2>페이지 내 어트리뷰트 : ${pageScope.page_name }</h2>
	<h2>request내 어트리뷰트 : ${requestScope.request_name }</h2>
	<h2>세션 내 어트리뷰트 : ${sessionScope.session_name }</h2>
	<h2>application 내 어트리뷰트 : ${applicationScope.application_name }</h2>
	<hr>
	<h2>페이지 내 어트리뷰트 : ${page_name }</h2>
	<h2>request내 어트리뷰트 : ${request_name }</h2>
	<h2>세션 내 어트리뷰트 : ${session_name }</h2>
	<h2>application 내 어트리뷰트 : ${application_name }</h2>
</body>
</html>