<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동전있는 곳을 맞춰봐</title>
<style>
	#wrap {width:150px; margin: 30px auto;}
	h2{color:red;text-align: center;}
</style>
<script>
	function btn(su){
		location.href = '08_yabaCertification.jsp?su='+su;
	}
</script>
</head>
<body>
	<div id="wrap">
		<button onclick="btn(1)">1번</button>
		<button onclick="btn(2)">2번</button>
		<button onclick="btn(3)">3번</button>
		<br><br>
		
	</div>
	<%
		String msg = request.getParameter("msg");
		if(msg!=null)
			out.println("<h2>"+msg+"</h2>");
	%>
</body>
</html>