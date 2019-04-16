<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.BufferedReader"%>
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
		String conPath = request.getContextPath();  
		String appPath = application.getContextPath(); //상대경로
		String absolutePath = application.getRealPath(".");
		String filePath = application.getRealPath("WEB-INF/input.txt");
	%>
	<h2>상대경로 : <%=appPath %></h2>
	<h2>절대경로 : <%=absolutePath %></h2>
	<h2>파일경로 : <%=filePath %></h2>	
	<%
	BufferedReader reader = null;
	try{
		reader = 
				new BufferedReader(new FileReader(filePath));
		while(true){
			String str = reader.readLine();
			if(str==null) break;
			out.println(str+"<br>");
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
		out.println(filePath+" 해당화일이 존재하지 않습니다");
	}finally{
		if(reader!=null) reader.close();
	}
	%>
</body>
</html>














