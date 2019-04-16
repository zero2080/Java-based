<%@page import="com.tj.dto.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css">
	<%String result = request.getParameter("result");
		if(result!=null && result.equals("1")){	%>
			<script>alert('친구추가 성공');</script>
	<%}else if(result!=null && result.equals("0")){ %>
			<script>alert('친구추가 실패. 이름이나 전화번호가 넘 길면 안되요');</script>
	<%} %>
	<script>
		function search(){
			var name = document.getElementsByName('name')[0].value;
			var phone= document.getElementsByName('phone')[0].value;
			location.href = 'friendInput2.jsp?name='+name+'&phone='+phone;
		}
	</script>
</head>
<body>
	<form action="friendInput2Ok.jsp">
		<p>
			친구이름 <input type="text" name="name" required="required" size="5"
				value="<%
					String name = request.getParameter("name");
					if(name!=null) out.print(name);
				%>"
			>
			전화 <input type="text" name="phone" required="required" size="5"
				value="<%
						String phone = request.getParameter("phone");
					if(phone!=null) out.print(phone);
				%>"
			>
			<input type="submit" value="추가">
			<input type="button" value="검색" onclick="search()">
		</p>
	</form>
	<%
		FriendDao fDao = FriendDao.getInstance();
		if(name==null) name = "";
		if(phone==null) phone = "";
		ArrayList<FriendDto> dtos = fDao.friendSelect(name, phone);
	%>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화</th></tr>
		<%for(int i=0 ; i<dtos.size() ; i++){%>
			<tr><td><%=dtos.get(i).getNo() %></td>
					<td><%=dtos.get(i).getName() %></td>
					<td><%=dtos.get(i).getPhone() %></td>
			</tr>
		<%} %>
	</table>
</body>
</html>