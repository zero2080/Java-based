<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>td{padding:10px;}</style>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int x = (num1>=num2)? num2 : num1;
	int y = (num1>=num2)? num1 : num2;
	System.out.println("작은수 : "+x +", 큰수 :"+y);

%>
	<h2><%=x%>단부터 <%=y %>단까지 구구단 출력</h2>
	<table>
<%	for(int i=1 ; i<10 ; i++){%>
		<tr>
		<%for(int j=x ; j<=y ; j++){%>
			<td><%=j %> * <%=i %> = <%=j*i %></td>
<%		}%>
		</tr>
<%	}%>
	</table>
	<br><br>
	<button onclick="location.href='6_inputDansu.html'">뒤로가기</button>
</body>
</html>


