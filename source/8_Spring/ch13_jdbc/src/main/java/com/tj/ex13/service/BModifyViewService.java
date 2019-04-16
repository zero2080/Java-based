package com.tj.ex13.service;
import java.util.Map;
import org.springframework.ui.Model;

import com.tj.ex13.dao.BoardDao;
import com.tj.ex13.dto.BoardDto;
public class BModifyViewService implements BService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = new BoardDao();
		BoardDto bDto = bDao.modifyView_replyView(bid);
		model.addAttribute("modify_view", bDto);
	}
}
