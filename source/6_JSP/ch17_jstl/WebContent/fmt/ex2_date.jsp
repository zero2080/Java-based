<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
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
	<c:set var="now" value="<%=new Date(System.currentTimeMillis()) %>"/>
	now : ${now } <br>
	time-short:<fmt:formatDate value="${now }" type="time" timeStyle="short"/><br>
	time-medium<fmt:formatDate value="${now }" type="time" timeStyle="medium"/><br>
	time-long<fmt:formatDate value="${now }" type="time" timeStyle="long"/><br>
	time-full<fmt:formatDate value="${now }" type="time" timeStyle="full"/><br>
	<c:set var="nowT" value="<%=new Timestamp(System.currentTimeMillis()) %>"/>
	nowTime : ${nowT }
	date-short<fmt:formatDate value="${nowT }" type="date" dateStyle="short"/><br>
	date-medium<fmt:formatDate value="${nowT }" type="date" dateStyle="medium"/><br>
	date-long<fmt:formatDate value="${nowT }" type="date" dateStyle="long"/><br>
	date-full<fmt:formatDate value="${nowT }" type="date" dateStyle="full"/><br>
	<hr>
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="long"/><br>
	<fmt:formatDate value="${now }" pattern="yyyy/MM/dd(E) hh:mm:ss(a)"/>
</body>
</html>