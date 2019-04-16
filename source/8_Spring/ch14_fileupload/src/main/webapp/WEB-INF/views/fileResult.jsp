<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>첨부결과 : 
	<c:if test="${not empty fileupResult }">${fileupResult }</c:if>
	<c:if test="${empty fileupResult }">실패</c:if>
	</h2>
	<h2>첨부파일1 : ${fileNames[0] }</h2>
	<h2>첨부파일2 : ${fileNames[1] }</h2>
	<h2>첨부파일3 : ${fileNames[2] }</h2>
	<c:if test="${not empty fileupResult }">
	<img src="${conPath }/upload/${fileNames[0] }" alt="file1">
	<img src="${conPath }/upload/${fileNames[1] }" alt="file2">
	<img src="${conPath }/upload/${fileNames[2] }" alt="file3">
	</c:if>
</body>
</html>






