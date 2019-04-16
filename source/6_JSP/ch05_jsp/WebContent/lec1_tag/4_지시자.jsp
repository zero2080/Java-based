<%@page import="java.util.Arrays"%>
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
	int[] arr = {10,20,30};
	out.println(Arrays.toString(arr));
	%>
	~ ~ ~ ~ ~ footer ~ ~ ~ ~ ~<br>
	<%@ include file="../member/footer.jsp" %>
	~ ~ ~ ~ ~ footer 끝~ ~ ~ ~ ~<br>
	<h2>다시 4_지시자.jsp로 돌아옴</h2>
</body>
</html>














