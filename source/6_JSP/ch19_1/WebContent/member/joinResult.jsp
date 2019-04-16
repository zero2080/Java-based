<%@page import="com.tj.ex.dao.MemberDao"%>
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
</head>
<body>
	<c:set var="SUCCESS" value="<%=MemberDao.SUCCESS %>"/>
	<%-- <c:if test="${joinResult eq SUCCESS}">
		<h1>회원가입 성공</h1>
	</c:if>
	
	<c:if test="${joinResult != SUCCESS}">
		<h1>회원가입 실패</h1>
	</c:if> --%>
	<h1>${joinResult eq SUCCESS? "회원가입성공":"회원가입실패"}</h1>
	<h1><a href="${conPath }/membersAll.do">회원리스트</a></h1>
</body>
</html>