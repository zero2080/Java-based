<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		String[] pets = request.getParameterValues("pets");
	%>
	<h2>선택하신 동물 : 
	<% if(pets!=null){
		for(String pet : pets) {%>
			<%=pet %> &nbsp;
	<%	}
	   } %>
	</h2> --%>
	<h2>ID : ${param.id }</h2>
	<h2>선택하신 동물 : ${paramValues.pets[0] }
					${paramValues.pets[1] }
					${paramValues.pets[2] }
					${paramValues.pets[3] }</h2>
</body>
</html>


















