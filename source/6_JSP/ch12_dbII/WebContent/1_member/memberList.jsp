<%@page import="com.tj.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		MemberDao mDao = MemberDao.getInstance();
		ArrayList<MemberDto> dtos = mDao.memberSelectAll();
	%>
	<table>
		<caption>가입한 회원 리스트</caption>
		<tr><th>이름</th><th>ID</th><th>비번</th><th>전화번호</th><th>성별</th></tr>
		<%
		if(dtos.size()==0){
			out.print("<tr><td colspan='5'>가입한회원이 없습니다</td></tr>");
		}else{
			for(MemberDto d : dtos){
		%>
				<tr><td><%=d.getName() %></td><td><%=d.getId() %></td>
						<td><%=d.getPw() %></td>
						<td><%=d.getPhone1() %>-<%=d.getPhone2() %>-<%=d.getPhone3() %></td>
						<td><%=d.getGender() %></td>
				</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>




















