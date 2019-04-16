<%@page import="com.tj.member.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.member.MemberDto"%>
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
		MemberDto dto = new MemberDto("ccc","333","박길동","p@tj.com",
											Timestamp.valueOf("1955-01-01 00:00:00"),
											new Date(System.currentTimeMillis()), "서울시 종로구"); 
	  out.println("<h2>ccc 아이디 중복 체크 </h2>");
	  MemberDao dao = MemberDao.getInstance();
	  int result = dao.confirmId("ccc");
	  if(result==MemberDao.MEMBER_EXISTENT){
		  out.println("<h4>ccc는 중복된 아이디라서 가입 불가</h4>");
	  }else if(result == MemberDao.MEMBER_NONEXISTENT){
		  out.println("<h4>ccc는 가입 가능한 아이디입니다</h4>");
		  result = dao.insertMember(dto);
		  out.println("<h4>"+
		  		(result==MemberDao.SUCCESS? "가입성공":"가입실패")+"</h4>");
	  }
	  out.println("<hr>");
	  result = dao.loginCheck("ccc", "333");
	  if(result == MemberDao.LOGIN_FAIL_ID){
		  out.println("<h4>아이디가 틀렸어</h4>");
	  }else if(result == MemberDao.LOGIN_FAIL_PW){
		  out.println("<h4>비밀번호가 틀렸어</h4>");
	  }else if(result == MemberDao.LOGIN_SUCCESS){
		  out.println("<h4>로그인 성공</h4>");
	  }
	  out.println("<hr>");
	  MemberDto dto2 = dao.getMember("ccc");
	  out.println("<h3>회원정보 수정 전 데이터 : "+ dto2.toString()+"</h3>");
	  out.println("수정<br>");
	  MemberDto dto3 = new MemberDto("ccc","ccc","홍XX","xx@tj.com",
				Timestamp.valueOf("1995-12-01 00:00:00"),
				new Date(System.currentTimeMillis()), "서울시 XX구"); 
	  result = dao.modifyMember(dto3);
	  if(result == MemberDao.SUCCESS){
		  out.println("<h4>회원정보 수정 성공</h4>");
	  }else{
		  out.println("<h4>회원정보 수정 실패</h4>");
	  }
	  dto2 = dao.getMember("ccc");
	  out.print("<h3>회원정보 수정 후 데이터 : "+dto2.toString()+"</h3>");
	%>
</body>
</html>