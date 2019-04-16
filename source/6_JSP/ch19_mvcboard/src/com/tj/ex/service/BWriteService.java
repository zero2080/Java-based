package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
public class BWriteService implements BService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bname    = request.getParameter("bname");
		String btitle   = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip      = request.getRemoteAddr();
		BoardDao boardDao = new BoardDao();
		int result = boardDao.write(bname, btitle, bcontent, bip);
		request.setAttribute("writeResult", result);
	}
}
