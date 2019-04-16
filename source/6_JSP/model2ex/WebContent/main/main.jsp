<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#content {
		width: 800px; height:350px;
		margin: 150px auto 0px;
	}
	#content h1{text-align: center;}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<h1><a href="${conPath }/list.do">사용자 모드</a></h1>
		<h1><a href="${conPath }/adminloginView.do">관리자 모드</a></h1>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>