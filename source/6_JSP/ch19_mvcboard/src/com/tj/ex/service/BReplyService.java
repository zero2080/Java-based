package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
public class BReplyService implements BService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bgroup   = Integer.parseInt(request.getParameter("bgroup"));
		int bstep    = Integer.parseInt(request.getParameter("bstep"));
		int bindent  = Integer.parseInt(request.getParameter("bindent"));
		String bname = request.getParameter("bname");
		String btitle= request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		BoardDao boardDao = new BoardDao();
		int result = 
			boardDao.reply(bname, btitle, bcontent, bip, bgroup, bstep, bindent);
		request.setAttribute("replyResult", result);
	}
}