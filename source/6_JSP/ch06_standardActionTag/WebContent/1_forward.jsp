<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>1_forward.jsp 파일입니다</h1>
	<jsp:forward page="2_forward.jsp"/>
	<%-- <%response.sendRedirect("2_forward.jsp");%> --%>
	<!-- HTML 주석 -->
</body>
</html>



