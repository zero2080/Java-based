package com.tj.ex;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MembersAllService implements Service {
	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request, 
			HttpServletResponse response) {
		MemberDao memberDao = MemberDao.getInstance();
		return memberDao.getMembersAll();
	}
}