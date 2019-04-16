package com.tj.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.ZzDao;
import com.tj.ex.dto.ZzDto;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		String requestPageNum = (String)request.getAttribute("pageNum");
		if(pageNum==null) {
			if(requestPageNum==null)
				pageNum = "1";
			else
				pageNum = requestPageNum;
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=5;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow   = startRow + PAGESIZE -1;
		ZzDao dao = new ZzDao();
		int totCnt = dao.getBoardTotCnt(); // 글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);//페이지갯수
		ArrayList<ZzDto> list = dao.list(startRow, endRow);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("list", list);
	}
}
