<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request"/>
	<jsp:setProperty name="pi" property="name" 
														value="<%=request.getParameter(\"name\") %>"/>
	<jsp:setProperty name="pi" property="age" 
					value='<%=Integer.parseInt(request.getParameter("age")) %>'/>
	<jsp:setProperty name="pi" property="gender" 
														value='<%=request.getParameter("gender") %>'/>
	<jsp:forward page="personResult.jsp"/>
</body>
</html>


















