<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/join.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="joinForm_wrap">
	<%request.setCharacterEncoding("utf-8");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			if(name.equals("hobby") || name.equals("mailSend")){
				String[] values = request.getParameterValues(name);
				out.println(name + " : "+ Arrays.toString(values)+"<br>");
				/* out.println(name + " : ");
				for(String v : values){
					out.println(v + "  ");
				}
				out.println("<br>"); */
			}else{
				String value = request.getParameter(name);
				out.println(name + " : "+value+"<br>");
			}
		}
		out.println("<hr>");
		Map<String, String[]> map = request.getParameterMap();
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			String name = iterator.next();
			String[] values = map.get(name);
			//out.println(name + " : "+Arrays.toString(values)+"<br>");
			if(name.equals("hobby") || name.equals("mailSend")){
				out.println(name + " : ");
				for(String v : values)
					out.println(v + " ");
				out.println("<br>");
			}else{
				out.println(name + " : " +values[0]+"<br>");
			}
		}
		out.println("<hr>");
		String hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String pw   = request.getParameter("pw");
		Date birth = Date.valueOf(request.getParameter("birth"));
		Timestamp birth2 = 
				Timestamp.valueOf(request.getParameter("birth")+" 00:00:00");
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email  = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
	%>
	hiddenParam : <%=hiddenParam %><br>
	name : <%=name %><br>
	 i d : <%=id %><br>
	 p w : <%=pw %><br>
	birth: <%=birth %><br> 
	birth2: <%=birth2 %><br>
	hobby : <%=Arrays.toString(hobby) %><br>
	성별 : <%=gender.equals("m")? "남자" : "여자" %><br>  
	수신메일 : <%=mailSend==null ? "모든메일거부":Arrays.toString(mailSend) %>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
















