<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<%-- <% // 본페이지는 반드시 로그인 한 후에 서비스 가능한 페이지
	String id = (String)session.getAttribute("id");
	if(id==null){ // 로그인 한 상태가 아닐 경우
		response.sendRedirect("login.jsp");
	}
%> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		//String id = session.getAttribute("id").toString();
		String id = (String)session.getAttribute("id");
		if(id!=null){ // 로그인 한 후
			out.println("<h2>"+id+"님 안녕하세요</h2>");
			out.println("<button onclick=\"location='logout.jsp'\">로그아웃</button>");
			out.println("<button onclick=\"location='sessionTest.jsp'\">세션보기</button>");
		}else{ // 로그인 전
			out.println("<h2>로그아웃 상태입니다</h2>");
			out.println("<button onclick=\"location='login.jsp'\">로그인</button>");
			out.println("<button onclick=\"location='sessionTest.jsp'\">세션보기</button>");
		}
	%>
</body>
</html>

















