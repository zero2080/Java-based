package com.tj.ex.service;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MembersAllService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao memberDao = MemberDao.getInstance();
		ArrayList<MemberDto> members = memberDao.getMembersAll();
		request.setAttribute("membersAll", members);
	}
}