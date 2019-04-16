<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function chk(){
		var num = frm.num.value.trim();
		if(isNaN(Number(num)) || num.indexOf('.')!=-1 ||
				Number(num)<=0){
			alert('자연수를 입력하세요');
			frm.num.value = '';
			frm.num.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<%
	String numParam = request.getParameter("num");
	%>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" onsubmit="return chk()" name="frm">
			숫자 <input type="text" name="num" value="<%
			if(numParam!=null) out.print(numParam.trim());
			%>">
			<input type="submit" value="누적">			
		</form>
	</fieldset>
	<%
	if(numParam!=null){
		int num = Integer.parseInt(numParam.trim());
		int total = 0;
		for(int i=1 ; i<=num ; i++)
			total += i;
		out.println("<h2>1부터 "+num+"까지 누적합 : "+total+"</h2>");
	}
	%>
</body>
</html>













