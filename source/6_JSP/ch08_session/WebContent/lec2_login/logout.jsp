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
		String id = (String)session.getAttribute("id");
		if(id!=null){ // 로그인 상태이므로 로그아웃
			session.removeAttribute("id");
			session.removeAttribute("pw");
			// session.invalidate(); - 세션 속성 데이터 모두 지워
			out.println("<h2>로그아웃이 완료되었습니다</h2>");
		}else{ // 로그인 상태가 아님
			out.println("<h2>로그인 상태가 아닙니다</h2>");
		}
	%>
	<button onclick="location.href='login.jsp'">로그인</button>
	<button onclick="location.href='sessionTest.jsp'">세션보기</button>
</body>
</html>

















