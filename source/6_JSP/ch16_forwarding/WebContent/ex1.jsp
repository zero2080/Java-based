<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 서블릿에서 넘어온 id : ${requestScope.id }<br>
	서블릿에서 넘어온 id : ${id }<br>
	서블릿에서 넘어온 pw : ${requestScope.pw }<br>
	서블릿에서 넘어온 pw : ${pw }<br> --%>
	<jsp:forward page="ex2.jsp"/>
</body>
</html>