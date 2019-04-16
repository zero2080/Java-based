<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date, java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	Date now = new Date();
	String str = String.format("%TY년 %Tm월 %Td일 %TH시 %TM분 %TS초",
			now, now, now, now, now, now);
	GregorianCalendar now2 = new GregorianCalendar();
	String str2 = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초",
			now2);
	Calendar now3 = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
	String str3 = sdf.format(now3.getTime());
%>
	<h1>현재는 <%=str  %>입니다</h1>
	<h1>현재는 <%=str2  %>입니다</h1>
	<h1>현재는 <%=str3 %>입니다</h1>
</body>
</html>











