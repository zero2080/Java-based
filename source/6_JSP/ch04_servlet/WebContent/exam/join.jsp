<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/join.css" rel="stylesheet" type="text/css">
<script>
	function chkJoinInfo(){
		if(frmJoin.pw.value!=frmJoin.pwChk.value){
			alert('비밀번호를 확인하세요');
			frmJoin.pw.value = '';
			frmJoin.pwChk.value = '';
			frmJoin.pw.focus();
			return false;
		}
		var booleanHobby = 0;
		for(var i=0 ; i<frmJoin.hobby.length ; i++){
			if(frmJoin.hobby[i].checked){
				booleanHobby ++;
			}
		}
		if(!booleanHobby){
			alert('취미를 하나이상 선택하세요');
			return false;
		}
		/* if(!frmJoin.hobby[0].checked && !frmJoin.hobby[1].checked && 
				!frmJoin.hobby[2].checked && !frmJoin.hobby[3].checked){
			alert('취미를 하나이상 선택하세요');
			return false;
		} */
	}
	window.onload = function(){
		document.getElementById('frmJoin').onsubmit = function(){
			var pw = document.getElementById('pw');
			var pwChk = document.getElementById('pwChk');
			if(pw.value!=pwChk.value){
				alert('비밀번호를 확인하세요');
				pw.value = pwChk.value = '';
				pw.focus();
				return false;
			}
			var booleanHobby = 0;
			var hobby = document.getElementsByName('hobby');
			for(var i=0 ; i<hobby.length ; i++){
				if(hobby[i].checked){
					booleanHobby++;
				}
			}
			if(!booleanHobby){
				alert('취미를 하나이상 선택하세요');
				return false;
			}
			/* if(!hobby[0].checked && hobby[1].checked==false && 
					hobby[2].checked==false && hobby[3].checked==false){
				alert('취미를 하나이상 선택하세요');
				return false;
			}  */
		};
	};
</script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="../join" method="post" id="frmJoin"
			onsubmit="return chkJoinInfo()">
			<div id="join_title">회원가입</div>
			<input type="hidden" name="hiddenParam" value="xx">
			<table>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id" required="required"></td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" required="required"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td><input type="password" name="pwChk" id="pwChk" required="required"></td>
				</tr>
				<tr>
					<th><label for="birth">생년월일</label></th>
					<td><input type="date" name="birth" id="birth" required="required"></td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="독서" id="reading"><label for="reading">독서</label>
						<input type="checkbox" name="hobby" value="요리" id="cooking"><label for="cooking">요리</label>
						<input type="checkbox" name="hobby" value="운동" id="exercise"><label for="exercise">운동</label>
						<input type="checkbox" name="hobby" value="취침" id="sleep"><label for="sleep">취침</label>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="m" checked="checked" id="m"><label for="m">남자</label>
						<input type="radio" name="gender" value="f" id="f"><label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<th><label for="email">이메일</label></th>
					<td><input type="email" name="email" id="email" required="required"></td>
				</tr>
				<tr>
					<th><label for="mailSend">메일수신</label></th>
					<td>
						<select name="mailSend" multiple="multiple" id="mailSend">
							<option value="광고">광고</option>
							<option>배송</option>
							<option selected="selected">공지</option>
							<option>댓글</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="뒤로가기" class="joinBtn_style"
								onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>