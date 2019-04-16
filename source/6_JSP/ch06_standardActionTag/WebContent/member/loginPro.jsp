<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		boolean isValid = false;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id!=null && id.equals("aaa") && pw!=null && pw.equals("111")){
			isValid = true;
		}
		if(!isValid){
			response.sendRedirect("login.jsp?msg=x");
		}
	%>
	<div id="loginForm_wrap">
		<div id="login_title">로그인 결과</div>
		<p id="login_join">로그인 성공</p>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>









