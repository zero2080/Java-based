package com.tj.ex13.service;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.ui.Model;

import com.tj.ex13.dao.BoardDao;
import com.tj.ex13.dto.BoardDto;
public class BListService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap(); // model을 map으로 전환
		String pageNum = (String)map.get("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE=10, BLOCKSIZE=10;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		BoardDao bDao = new BoardDao();
		ArrayList<BoardDto> list = bDao.list(startRow, endRow);
		int orderNum = startRow;// 출력순번(정순)
		int totCnt = bDao.getBoardTotCnt(); // 글 갯수
		int inverseNum = totCnt - startRow +1; // 출력순서역번(역순)
		model.addAttribute("list", list);
		model.addAttribute("orderNum", orderNum);
		model.addAttribute("totCnt", totCnt);
		model.addAttribute("inverseNum", inverseNum);
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt) {
			endPage = pageCnt;
		}
		model.addAttribute("pageCnt", pageCnt);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("BLOCKSIZE", BLOCKSIZE);
		model.addAttribute("pageNum", pageNum);
	}
}