<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> i값은 <%=i %></h1>
	<h1>str값은 <%=str %></h1>
	<h1>sum(2,3)은 <%=sum(2,3) %></h1>
	<hr>
<%!
	int i; //전역변수
	String str = "ABCD";
	public int sum(int a, int b){
		return a+b;
	}
%>
<%	out.println("<h1> i값은 "+i+"</h1>");
	out.println("<h1> str값은 "+str+"</h1>");
	out.println("<h1> sum(2,3)은 "+sum(2,3)+"</h1>");
%>
</body>
</html>