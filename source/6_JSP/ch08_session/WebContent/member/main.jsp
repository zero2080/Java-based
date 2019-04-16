<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		#mainForm_wrap {width:1000px; margin: 0 auto;
			height: 620px; line-height: 620px; font-size: 3em;
			text-align: center;
			color:#A47160;
			border: 1px solid #D4A190;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="mainForm_wrap">
		MAIN 화면
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>




