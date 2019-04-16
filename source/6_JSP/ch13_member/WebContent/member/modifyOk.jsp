<%@page import="com.tj.member.MemberDao"%>
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
	<%	request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="com.tj.member.MemberDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		Timestamp birth = 
						Timestamp.valueOf(request.getParameter("bbirth")+" 00:00:00");
		dto.setBirth(birth);
		String nowPw = request.getParameter("nowPw");
		String sessionPw = (String)session.getAttribute("pw");
		if(nowPw.equals(sessionPw)){ // 정보수정 진행
			if(dto.getPw()==null || dto.getPw().equals("")){
				dto.setPw(sessionPw);
			}
			MemberDao dao = MemberDao.getInstance();
			int result = dao.modifyMember(dto); // 정보수정
			if(result == MemberDao.SUCCESS){
				session.setAttribute("pw", dto.getPw());
				session.setAttribute("name", dto.getName());
				session.setAttribute("member", dto);
	%>
				<script>
					alert('회원정보 수정이 완료되었습니다');
					location.href = 'main.jsp';
				</script>	
	<%	}else if(result == MemberDao.FAIL){ %>
				<script>
					alert('회원정보 수정이 거부되었습니다. 데이터의 길이를 확인하세요');
					history.back();
				</script>
	<%	}			
		}else{
	%>
			<script>
				alert('현비번이 틀렸습니다. 확인하세요');
				location.href='modify.jsp';
			</script>
			
	<%}	%>
</body>
</html>