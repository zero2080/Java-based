<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표현식 태그 </h1>
	산술연산 : 10+1 = <%=10+1 %> <br>
	산술연산 : 10 / 0.0 = <%=10/0.0 %><br>
	관계연산 : 1 > 2 = <%= 1>2 %> <br>
	관계연산 : 1 &lt; 2 = <%= 1<2 %> <br>
	관계연산 : 1 == 2 = <%= 1 == 2 %> <br>
	삼항연산 : <%= ( 1 > 2) ? "1>2입니다" : "1>2가 아닙니다" %><br>
	로그인여부 : <%=(session.getAttribute("validMember")==null) ? "로그인전":"로그인후"%>
	로그인여부 : <%=(session.getAttribute("validMember")!=null) ? "로그인후":"로그인전"%><br>
	논리연산 : (1>2) || (1&lt;2) = <%=(1>2) || (1<2) %>
	<hr>
	<h1>EL 표기법</h1>
	산술연산 : 10+1 = ${10+1 } <br>
	산술연산 : 10/0 = ${10/0 } <br>
	관계연산 : 1 > 2 = ${ 1 gt 2 }<br>
	관계연산 : 1 > 2 = ${ 1 > 2 }<br> 
	관계연산 : 1 &lt; 2 = ${ 1 lt 2 }<br>
	관계연산 : 1 &lt; 2 = ${ 1 < 2 }<br>
	관계연산 : 1 == 2 = ${ 1 eq 2 } <br>
	관계연산 : 1 == 2 = ${ 1 == 2 } <br>
	삼항연산 : ${( 1 > 2) ? "1>2입니다" : "1>2가 아닙니다" }<br>
	로그인여부 : ${empty validMember ? "로그인전":"로그인후"}
	로그인여부 : ${not empty validMember? "로그인후":"로그인전" }<br>
	논리연산 : (1>2) || (1&lt;2) = ${(1 gt 2) || (1 lt 2) }<br>
</body>
</html>
























