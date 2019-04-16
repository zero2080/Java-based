<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$('form').submit(function(){
				if($('#name').val().length<1){
					alert('이름은 한글자 이상');
					$('#name').focus();
					return false;
				}
				var kor = Number($('#kor').val());
				if(isNaN(kor) || kor<0 || kor>100 || $('#kor').val()==''){
					alert('국어 점수는 0~100점이어야 합니다');
					$('#kor').focus();
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<p id="cnt">"현재 총 ${cnt }명"</p>
	<form action="${conPath }/input.do">
		<table>
			<caption>개인 정보 입력</caption>
			<tr><th>이 름 : </th>
					<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr><th>국 어 : </th>
					<td><input type="text" name="kor" id="kor"></td>
			</tr>
			<tr><th>영 어 : </th>
					<td><input type="number" name="eng" id="eng" min="0" max="100"></td>
			</tr>
			<tr><th>수 학 : </th>
					<td><input type="number" name="mat" id="mat" min="0" max="100"></td>
			</tr>
			<tr><th colspan="2">
						<input type="submit" value="입력">
					</th>
			</tr>
		</table>
	</form>
</body>
</html>