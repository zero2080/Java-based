<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.println("num1 = "+num1+"<br>");
		out.println("num2 = "+num2+"<br>");
		out.println("num1+num2 = "+(num1+num2)+"<br>");
		try{
			out.println("num1/num2 = "+(num1/num2)+"<br>");
		}catch(Exception e){
			out.println("/0은 불가합니다<br>");
		}
		out.println("num1*num2 = "+(num1*num2)+"<br>");
		out.println("num1-num2 = "+(num1-num2)+"<br>");
		out.println("DONE");
	%>
</body>
</html>
















