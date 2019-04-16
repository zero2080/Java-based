<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int age = Integer.parseInt(request.getParameter("age"));
		if(age>=19){
			// 6_pass.jsp 페이지로
			response.sendRedirect("06_pass.jsp?age="+age);
		}else{
			// 6_ng.jsp 페이지로
			response.sendRedirect("06_ng.jsp?age="+age);
		}
	%>
</body>
</html>