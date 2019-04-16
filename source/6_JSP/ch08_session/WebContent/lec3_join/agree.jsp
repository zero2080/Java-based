<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();
	request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
	<style>h2{text-align: left;}</style>
	<script>
		// 거부를 선택하고 submit버튼을 click하면 submit이 일어나지 않게
		/* window.onload = function(){
			document.getElementById('frm').onsubmit = function(){
				var n = document.getElementById('n');
				if(n.checked==true){
					alert('동의를 하셔야 진행이 됩니다');
					return false;
				}
			};
		}; */
	</script>
</head>
<body>
	<%// 파라미터로 넘어온 id, pw, name을 세션에 저장해 두기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		if(id==null || pw==null || name==null){
			response.sendRedirect("join.html");
		}
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("name", name);
		// 화면처럼 동의or거부 입력받는 화면 만들기
	%>
	<h2><%=name %>님 약관에 동의하십니까?</h2>
	<hr>
	<ul>
		<li>회원정보는 웹사이트의 운영을 위해서만 사용됩니다</li>
		<li>웹사이트의 정상적인 운영을 방해하는 회원은 탈퇴 처리합니다</li>
	</ul>
	<hr>
	<fieldset>
		<legend>약관 동의</legend>
		<form action="joinOk.jsp" id="frm">
			<label for="y">동의</label>
			<input type="radio" name="agree" value="y" id="y">
			<label for="n">거부</label>
			<input type="radio" name="agree" value="n" id="n"
						checked="checked">
			&nbsp; &nbsp;
			<input type="submit" value="확인">
		</form>
	</fieldset>
</body>
</html>
















