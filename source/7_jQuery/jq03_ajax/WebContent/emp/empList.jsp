<%@page import="com.tj.ex.dto.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.ex.dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {background-color: white;}
		th { background-color: blue; color: white; padding:10px;}
		td { background-color: lightblue; padding:10px;
					text-align: center;
		}
	</style>
</head>
<body>
	<%
		String schEname = request.getParameter("schEname");
		String schJob  = request.getParameter("schJob");
		EmpDao eDao    = EmpDao.getInstance();
		ArrayList<EmpDto> emps = eDao.list(schEname, schJob);
	%>
	<c:set var="emps" value="<%=emps %>"/>
	<table>
		<tr><th>사원번호</th><th>사원명</th><th>직책</th>
				<th>관리자번호</th><th>입사일</th><th>연봉</th>
				<th>보너스</th><th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${emps }">
			<tr><td>${emp.empno }</td><td>${emp.ename }</td><td>${emp.job }</td>
					<td>${emp.mgr }</td><td>${emp.hiredate }</td>
					<td><fmt:formatNumber value="${emp.sal }" pattern="####.0"/></td>
					<td><fmt:formatNumber value="${emp.comm }" pattern="##0.0"/></td>
					<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
		<tr><td colspan="8">총 데이터 : ${emps.size() } 건</td></tr>
	</table>
</body>
</html>











