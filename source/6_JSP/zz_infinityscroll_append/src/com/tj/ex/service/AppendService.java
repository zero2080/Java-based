package com.tj.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tj.ex.dao.ZzDao;
import com.tj.ex.dto.ZzDto;

public class AppendService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		final int PAGESIZE=5;
		int currentPage = Integer.parseInt(pageNum);
		ZzDao dao = new ZzDao();
		int totCnt = dao.getBoardTotCnt(); // 글갯수
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);//페이지갯수
		System.out.println(pageCnt +"페이지 중 현재 "+currentPage);
		if(currentPage<pageCnt) {
			currentPage++;
			int startRow = (currentPage-1) * PAGESIZE +1;
			int endRow   = startRow + PAGESIZE -1;
			ArrayList<ZzDto> list = dao.list(startRow, endRow);
			request.setAttribute("list", list);
			HttpSession session = request.getSession();
			request.setAttribute("pageNum", currentPage);// pageNum 없으면 param.pageNum
		}else {
			request.setAttribute("error", "더이상페이지는 없어");
		}
	}
}
