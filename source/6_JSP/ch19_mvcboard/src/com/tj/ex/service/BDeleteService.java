package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
public class BDeleteService implements BService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		int result = boardDao.delete(bid);
		request.setAttribute("deleteResult", result);
	}
}
