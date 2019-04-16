<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#content { height: 710px;}
</style>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(document).ready(function() {
		$('#mPwChk').keyup(function(){
			if(frmJoin.mPw.value != frmJoin.mPwChk.value){
				$('.pwChkResult').html("<font color='red'>비밀번호가 동일하지 않습니다.</font>");
			} else {
				$('.pwChkResult').html("비밀번호가 일치합니다.");
			}
		});
	});
	function checkInfo() {		
		if(frmJoin.mPw.value != frmJoin.mPwChk.value){
			alert("패스워드가 일치하지 않습니다.");
			frmJoin.mPw.value="";
			frmJoin.mPwChk.value = "";
			return false;
		}
		if(frmJoin.mId.value.length<3){
				alert("아이디는 3글자 이상이어야합니다.");
				frmJoin.mId.focus();
				return false;
		}
		if(frmJoin.mPw.value.length<3){
				alert("패스워드는 3글자 이상이어야합니다.");
				frmJoin.mPw.focus();
				return false;
		}	
	}
</script>
<script src="address.js"></script>
<!-- jquery-ui 이용한 캘런더api -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
	  $("#datepicker").datepicker({
		  dateFormat : 'yy-mm-dd',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear : true,
			showOtherMonths : true,
			selectOtherMonths : false,
			yearSuffix : '년',
	  });
  } );
</script>
<script>
	function chk() {
		if(!frmJoin.mId.value){
			alert("아이디를 입력 후 중복확인을 하세요");
			frm.mId.focus();
			return false;
		}else{
			location.href= "confirmId.do?mId="+frmJoin.mId.value;
		}
	}
</script>
</head>
<body>
	<div id="content">
	<div id="joinForm_wrap">
		<form action="${conPath }/memberJoin.do" method="post" id="frmJoin" name="frmJoin" onsubmit="return checkInfo();">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="sample4_postcode">주소</label></th>
					<td><input type="text" name="mPost" id="sample4_postcode" placeholder="우편번호" style="width:60%; height:20px; padding:3px;">
						<input type="button" onclick="sample4_execDaumPost()" class="button_box" value="우편번호 찾기" style="width:30%; padding:3px;">
						<input type="text"  name="mAddress" id="sample4_roadAddress"  placeholder="도로명주소" style="width:95%; height:20px; padding:3px;">
						<input type="hidden" id="sample4_jibunAddress" name="mAddress3" class="text_box1"  placeholder="지번주소">
						<span id="guide" style="color:#999"></span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="가입하기" onclick="checkId_pw" class="joinBtn_style" style="width:100%; height:120%; padding:3px;">
				</tr> 
			</table>		
		</form>
	</div>
	</div>
</body>
</html>