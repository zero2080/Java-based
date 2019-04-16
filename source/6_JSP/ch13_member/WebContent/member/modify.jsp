<%@page import="com.tj.member.MemberDto"%>
<%@page import="com.tj.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet">
	<script src="../js/modify.js"></script>
</head>
<body>
	<%
		String id = (String)session.getAttribute("id");
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = dao.getMember(id);
	%>
	<form action="modifyOk.jsp" method="post" name="modify_frm">
		<input type="hidden" name="id" value="<%=dto.getId()%>">
		<table>
			<caption>정보수정</caption>
			<tr><th>아이디  </th>
					<td><%=dto.getId() %></td>
			</tr>
			<tr><th>현 비번 </th>
					<td><input type="password" name="nowPw" value="<%=dto.getPw()%>"></td>
			</tr>
			<tr><th>새 비번</th><td><input type="password" name="pw"></td></tr>
			<tr><th>새 비번</th><td><input type="password" name="pwChk"></td></tr>
			<tr><th>이름    </th>
					<td><input type="text" name="name" value="<%=dto.getName()%>"></td>
			</tr>
			<tr><th>메일주소</th>
					<td><input type="text" name="email" value="<%
					if(dto.getEmail()!=null) out.print(dto.getEmail()); %>"></td>
			</tr>
			<tr><th>생년월일</th>
					<td><input type="date" name="bbirth" 
								value="<%=dto.getBirth().toString().substring(0, 10)%>"></td>
			</tr>
			<tr><th>주소    </th>
					<td><input type="text" name="address" value="<%
						if(dto.getAddress()!=null) out.print(dto.getAddress());
					%>"></td>
			</tr>
			<tr><td colspan="2">
						<input type="button" value="정보수정" onclick="modifyInfoChk()">
						<input type="reset" value="취소">
						<input type="button" value="로그아웃" onclick="location='logout.jsp'">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>