<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>아래의 명령들을 클릭하면 *.do 서블릿으로 가게</h1>
	<h1><a href="http://localhost:8181/ch18/insert.do">INSERT</a></h1>
	<h1><a href="/ch18/select.do">SELECT</a></h1>
	<h1><a href="${conPath }/update.do">UPDATE</a></h1>
	<h1><a href="${conPath }/delete.do">DELETE</a></h1>
</body>
</html>










