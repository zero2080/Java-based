<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>2의 10승은 <%=power(2,10) %>입니다</h2>
<%! // 선언부 : 선언부부터 해석하므로 위에서나 아래에서 어디서든 호출가능
	private long power(int a, int b){
		long result = 1;
		for(int i=1 ; i<=b ; i++){
			result *= a; //result = result*a;
		}
		return result;
	}
%>
	<h2>3의 10승은 <%=power(3,10) %>입니다</h2>

</body>
</html>