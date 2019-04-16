<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String conPath = request.getContextPath(); 
		String validMem = (String)session.getAttribute("validMem");
		if(validMem==null){
			response.sendRedirect("login.jsp");
		}
		String msg = request.getParameter("msg");
		if(msg!=null){ %>
			<script>
				alert('현재 비밀번호를 확인하세요');
			</script>
<%	} %>		
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	String pw   = (String)session.getAttribute("pw");
	String phone1 = (String)session.getAttribute("phone1");
	String phone2 = (String)session.getAttribute("phone2");
	String phone3 = (String)session.getAttribute("phone3");
	String gender = (String)session.getAttribute("gender");
	%>
	<form action="<%=conPath %>/ModifyOk" method="post">
		<table>
			<tr><th>아이디</th>
					<td><input type="text" name="id" value="<%=id %>" readonly="readonly">
					</td>
			</tr>
			<tr><th>이름</th>
					<td><input type="text" name="name" value="<%=name %>" 
								required="required"></td>
			</tr>
			<tr><th>현재 비번</th>
					<td><input type="password" name="hyunPw" value="<%=pw %>"
								required="required"></td>
			</tr>
			<tr><th>바꿀 비번</th>
					<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr><th>전화번호</th>
					<td><%if(phone1!=null && phone1.equals("010")) { // 010%>
									<select name="phone1">
										<option>02</option>
										<option selected="selected">010</option>
									</select>
							<%}else{  // 02 %>
									<select name="phone1">
										<option selected="selected">02</option>
										<option>010</option>
									</select>
							<%} %>
							- <input type="text" name="phone2" value="<%=phone2 %>" size="2">
							- <input type="text" name="phone3" value="<%=phone3 %>" size="2">
					</td>
			</tr>
			<tr><th>성별</th>
					<td><%if(gender!=null && gender.equals("남")){ %>
								<input type="radio" name="gender" value="남" checked="checked">
								남자
								<input type="radio" name="gender" value="여">여자
							<%}else{ %>
								<input type="radio" name="gender" value="남">남자
								<input type="radio" name="gender" value="여" checked="checked">
								여자
							<%} %>
						</td>
			</tr>
			<tr><td colspan="2">
						<input type="submit" value="수정">
						<input type="reset" value="취소">
						<input type="button" value="이전" onclick="history.go(-1)">
					</td>
			</tr>
		</table>
	</form>
</body>
</html>















