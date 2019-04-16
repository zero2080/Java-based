<%@page import="com.tj.member.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.member.MemberDto" scope="page"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		Timestamp birth = 
					Timestamp.valueOf(request.getParameter("bbirth")+" 00:00:00");
		dto.setBirth(birth);
		MemberDao dao = MemberDao.getInstance();
		if(dao.confirmId(dto.getId())==MemberDao.MEMBER_NONEXISTENT){
			//회원가입 가능
			int result = dao.insertMember(dto); //가입
			if(result==MemberDao.SUCCESS){
				session.setAttribute("id", dto.getId());
	%>		
				<script>
					alert('회원가입 감사합니다. 로그인 이후 서비스를 이용하세요');
					location.href = 'login.jsp';
				</script>				
	<%	}else if(result == MemberDao.FAIL){%>
				<script>
					alert('회원가입 실패되었습니다');
					location.href = 'join.jsp';
				</script>
	<%	}
			
		}else{//회원가입 불가
	%>		
				<script>
					alert('중복된 ID입니다. 다른 아이디를 사용하세요');
					history.back();
				</script>
	<%	}	%>
</body>
</html>