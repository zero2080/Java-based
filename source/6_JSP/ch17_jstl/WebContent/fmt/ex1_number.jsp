<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="num1" value="1234567"/>
	${num1 }<br>
	<fmt:formatNumber value="${num1 }" groupingUsed="true"/>(3자리마다 ,)
	<fmt:formatNumber value="${num1 }" pattern="#,###.00"/>
</body>
</html>