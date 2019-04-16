<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="varName" value="<varValue>"/>
	varName : ${varName }<br>
	varName : <c:out value="${varName }" escapeXml="true"/><br>
	<c:remove var="varName"/>
	varName : ${varName }<br>
	varName : <c:out value="${varName }" default="없어졌네"/><br>
	<c:catch var="error">
		<%= 8/0.0 %>
		<p>예외가 발생되면 c:catch블록을 바로 빠져나가</p>
	</c:catch>
	<c:out value="${error }" default="예외가 발생 안 되었군"/>
</body>
</html>