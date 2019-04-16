package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MemberJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		MemberDto member = new MemberDto(id, pw, name, email, birth, null, address);
		MemberDao memberDao = MemberDao.getInstance();
		request.setAttribute("joinResult", memberDao.insertMember(member));
	}
}