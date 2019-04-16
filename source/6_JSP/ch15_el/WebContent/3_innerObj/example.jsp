<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		body{background-color: #ffffaa; text-align: center;}
		p {color:red;}
	</style>
</head>
<body>
	<form action="">
		<input type="text" name="num1" value="<%=(int)(Math.random()*9)+1%>" size="3">
		<b> * </b>
		<input type="text" name="num2" value="<%=(int)(Math.random()*9)+1%>" size="3">
		<b> = </b>
		<input type="text" name="result" size="3" value="${param.result}"><br><br>
		<input type="submit" value="확인">
	</form>
	<p>정답여부 ${param.num1 } * ${param.num2 } = ${param.result }는(은)	
		${(param.num1*param.num2) eq param.result ? "정답":"오답"}입니다
	</p>
</body>
</html>










