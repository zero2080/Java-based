<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<p id="cnt">"현재 총 ${cnt }명"</p>
	<h4>결과는 다음과 같습니다</h4>
	<h4>이 름 : ${student.name }</h4>
	<h4>국 어 : ${student.kor }</h4>
	<h4>영 어 : ${student.eng }</h4>
	<h4>수 학 : ${student.mat }</h4>
	<h4>총 점 : ${student.tot }</h4>
	<h4>평 균 : <fmt:formatNumber value="${student.avg }" pattern="###.##"/> </h4>
	<p id="buttons">
		<button onclick="history.back()">뒤로가기</button>
		<button onclick="location.href='${conPath}/inputForm.do'">다시입력</button>
	</p>
</body>
</html>