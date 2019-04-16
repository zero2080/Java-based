/**
 * join_frm.id가 3글자이상, pw==pwChk, 이름, 메일체크
 */
function joinInfoChk(){
	if(join_frm.id.value.length<3){
		alert('아이디는 반드시 3글자 이상');
		join_frm.id.focus();
		return;
	}
	if(!join_frm.pw.value){
		alert('비밀번호는 필수입력 사항입니다');
		join_frm.pw.focus();
		return;
	}
	if(join_frm.pw.value!=join_frm.pwChk.value){
		alert('비밀번호를 확인하세요');
		join_frm.pw.value='';
		join_frm.pwChk.value = '';
		join_frm.pw.focus();
		return;
	}
	if(!join_frm.name.value){
		alert('이름은 필수 입력 사항입니다');
		join_frm.name.focus();
		return;
	}
	if(join_frm.email.value.length!=0 &&(
			join_frm.email.value.indexOf('@') == -1 ||
			join_frm.email.value.indexOf('@') == 0  ||
			join_frm.email.value.indexOf('@') == 
				join_frm.email.value.length-1       ||
			join_frm.email.value.indexOf('@') !=
				join_frm.email.value.lastIndexOf('@') )){
		alert('메일 형식을 확인하세요');
		join_frm.email.focus();
		return;
	}
	if(!join_frm.bbirth.value){
		alert('생년월일은 필수 입력 사항입니다');
		join_frm.bbirth.focus();
		return;
	}
	join_frm.submit(); // submit 이벤트 강제 발생
}

















