<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="">
		검색할 이름 
		<input type="text" name="schName" value="${fn:toUpperCase(param.schName) }">
		검색할 직책
		<input type="text" name="schJob" value="${fn:toUpperCase(param.schJob) }">
		<input type="submit" value="검색">
	</form>
	<br>
	<table>
		<tr><th>사번</th><th>이름</th><th>job</th><th>mgr</th><th>입사</th>
				<th>sal</th><th>comm</th><th>deptno</th>
		</tr>
		<c:forEach var="emp" items="${emps }">
			<tr><td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr }</td>
					<td><fmt:formatDate value="${emp.hiredate }" pattern="yyyy/MM/dd(E)"/></td>
					<td><fmt:formatNumber value="${emp.sal }" pattern="#,###.0"/></td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>