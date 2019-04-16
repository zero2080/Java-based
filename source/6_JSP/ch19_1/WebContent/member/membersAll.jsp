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
	<table>
		<tr><th>번호</th><th>id</th><th>PW</th><th>이름</th><th>메일주소</th>
				<th>생년월일</th><th>가입일</th><th>주소</th>
		</tr>
		<c:if test="${membersAll.size() == 0 }">
			<tr><td colspan="8">가입한 회원이 없습니다</td></tr>
		</c:if>
		<c:if test="${membersAll.size() != 0 }">
			<c:set var="i" value="1"/>
			<c:forEach var="member" items="${membersAll }">
				<tr><td>${i }</td>
						<td>${member.id }</td>
						<td>${member.pw }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.birth }</td>
						<td>${member.rDate }</td>
						<td>${member.address }</td>
				</tr>
				<c:set var="i" value="${i+1 }"/>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>