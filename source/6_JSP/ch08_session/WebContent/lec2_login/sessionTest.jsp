<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		Enumeration<String> names = session.getAttributeNames();
		int cnt=0;
		while(names.hasMoreElements()){
			cnt++;
			String sName = names.nextElement(); 
			Object sValue = session.getAttribute(sName);
			out.print("<h2>세션명은 "+sName+"/세션값은 "+sValue.toString()+"</h2>");
		}
		if(cnt==0){
			out.print("<h2>세션데이터가 없습니다</h2>");
		}
	%>
	<button onclick="history.back();">이전페이지로</button>
	<button onclick="location.href='welcome.jsp'">welcome페이지로</button>
</body>
</html>

















