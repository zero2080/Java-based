<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>3_include.jsp파일입니다.</h1>
	<hr>
	<jsp:include page="member/footer.jsp"/>
	<hr>
	<%-- <%@include file="member/footer.jsp" %> --%>
	<hr>
	<h1>다시 3_include.jsp파일입니다</h1>
</body>
</html>