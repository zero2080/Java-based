package com.tj.ex.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;
public class BContentService implements BService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDao boardDao = new BoardDao();
		BoardDto dto = boardDao.contentView(bid);
		request.setAttribute("content_view", dto);
	}

}
