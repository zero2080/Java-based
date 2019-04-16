<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.loginCheck(id, pw);
		if(result == MemberDao.LOGIN_SUCCESS){
			MemberDto dto = dao.getMember(id);
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			session.setAttribute("name", dto.getName());
			session.setAttribute("validMember", "ok");
			
			session.setAttribute("member", dto);
			response.sendRedirect("main.jsp");
		}else if(result == MemberDao.LOGIN_FAIL_ID){
	%>
			<script>
				alert('존재하지 않는 ID입니다');
				history.back();
			</script>				
	<%}else if(result == MemberDao.LOGIN_FAIL_PW){%>
			<script>
				alert('비밀번호를 확인하세요');
				history.go(-1);
			</script>	
	<%}	%>
</body>
</html>