package com.tj.ex;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MemberJoinService implements Service{
	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String bbirth = request.getParameter("bbirth");
		Timestamp birth = null;
		if(bbirth!=null) {
			birth = Timestamp.valueOf(bbirth + " 00:00:00");
		}
		String address = request.getParameter("address");
		MemberDao memberDao = MemberDao.getInstance();
		MemberDto member = new MemberDto(id, pw, name, email, birth, 
					null, address); // rDate에는 null
		int joinResult = memberDao.insertMember(member);
		request.setAttribute("joinResult", joinResult);
		return null;
	}
}

















