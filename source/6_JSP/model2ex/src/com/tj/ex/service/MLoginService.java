package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MLoginService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// mId, mPw 파라미터값 받아 loginCheck
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		MemberDao mDao = new MemberDao();
		int result = mDao.loginCheck(mId, mPw);
		// loginCheck 결과가 SUCCESS면 세션에 추가
		// loginCheck 결과가 FAIL면 fail이유를 request.setAttribute
		if(result == MemberDao.LOGIN_SUCCESS) {
			HttpSession httpSession = request.getSession();
			MemberDto dto = mDao.getMember(mId);
			httpSession.setAttribute("mId", mId);
			httpSession.setAttribute("member", dto);
		}else if(result == MemberDao.LOGIN_FAIL_PW) {
			request.setAttribute("loginErrorMsg", "비밀번호를 확인하세요");
		}else if(result == MemberDao.LOGIN_FAIL_ID) {
			request.setAttribute("loginErrorMsg", "ID를 확인하세요");
		}
	}
}