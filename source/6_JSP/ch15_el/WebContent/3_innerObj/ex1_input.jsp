<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex1_inputView.jsp">
		<p>이름 <input type="text" name="name"></p>
		<p>아이디 <input type="text" name="id"></p>
		<p>비번 <input type="text" name="pw"></p>
		<p><input type="submit" value="전송"></p>
	</form>
	<%	pageContext.setAttribute("page_name", "page_value");
		request.setAttribute("request_name", "request_value"); // ★
		session.setAttribute("session_name", "session_value"); // ★
		application.setAttribute("application_name", "application_value");
		RequestDispatcher dispatcher 
		  = request.getRequestDispatcher("ex1_inputView.jsp?name=hong&id=aaa&pw=11");
		dispatcher.forward(request, response);
	%>
	
	<h2>세션 내 어트리뷰트 : <%=session.getAttribute("session_name") %></h2>
	<hr>
	<h2>페이지 내 어트리뷰트 : ${pageScope.page_name }</h2>
	<h2>request내 어트리뷰트 : ${requestScope.request_name }</h2>
	<h2>세션 내 어트리뷰트 : ${sessionScope.session_name }</h2>
	<h2>application 내 어트리뷰트 : ${applicationScope.application_name }</h2>
	<hr>
	<h2>페이지 내 어트리뷰트 : ${page_name }</h2>
	<h2>request내 어트리뷰트 : ${request_name }</h2>
	<h2>세션 내 어트리뷰트 : ${session_name }</h2>
	<h2>application 내 어트리뷰트 : ${application_name }</h2>
	
</body>
</html>





















