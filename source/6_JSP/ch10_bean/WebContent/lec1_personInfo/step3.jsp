<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- 뷰와 프로세스를 분리 --%>
	<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request"/>
	<jsp:setProperty name="pi" property="name" value="홍길동"/>
	<jsp:setProperty name="pi" property="age" value="22"/>
	<jsp:setProperty name="pi" property="gender" value="남"/>
	<jsp:forward page="personResult.jsp"/>
</body>
</html>




















