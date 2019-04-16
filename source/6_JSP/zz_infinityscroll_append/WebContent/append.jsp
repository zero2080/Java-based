﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">	
</head>
<body>
	<c:if test="${empty error }">
			<table>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.no }</td>
						<td>${dto.name }</td>
						<td>${dto.tel }</td>
						<td>${dto.addr }</td>
					</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="pageNum" class="pageNum" value="${pageNum }">
	</c:if>
</body>
</html>