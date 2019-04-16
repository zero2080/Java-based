<%@page import="java.util.Enumeration"%>
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
		String myStr = session.getAttribute("myStr").toString();
		int myNum = (Integer)session.getAttribute("myNum");
		out.println("myStr 세션 데이터 : "+myStr+"<br>");
		out.println("myNum 세션 데이터 : "+myNum+"<br>");
		out.println("<hr><h2>세션 데이터들 list</h2><hr>");
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			out.println(name +" : "+value.toString()+"<br>");
		}
		out.println("<hr>");
		out.println("세션 id = "+session.getId()+"<br>");
		out.println("세션유효시간 = "+session.getMaxInactiveInterval()+"<br>");
		out.println("<hr><h2>특정 세션데이터 삭제후 list</h2><hr>");
		session.removeAttribute("myStr");//특정 데이터만 삭제== 로그아웃시
		names = session.getAttributeNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			out.println(name +" : "+value.toString()+"<br>");
		}
		session.invalidate(); // 세션 모든 속성 데이터 다 삭제 == 로그아웃시
		if(request.isRequestedSessionIdValid()){
			out.println("<hr>세션 Valid");
		}else{
			out.println("<hr>세션 inValid"); //세션 속성 데이터가 모두 무효화
		}
	%>
</body>
</html>




















