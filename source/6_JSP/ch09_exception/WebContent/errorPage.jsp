<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%	response.setStatus(200);	//500 : 예외, 문법적인 오류
															//404 : 문서를 찾을 수 없는 경우
															//407 : 인증필요 경우
															//405 : 특별한 경우 자원을 허용 안 할 때
															//200 : 정상상태
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		console.log('예외 메세지 : <%=exception.getMessage()%>');
		console.log('예외 타입 : <%=exception.getClass().getName() %>');
	</script>
</head>
<body>
	<h1>0으로 나누는 부분이 공사중입니다</h1>
</body>
</html>







