package com.tj.ex13.service;
import java.util.Map;
import org.springframework.ui.Model;

import com.tj.ex13.dao.BoardDao;
public class BDeleteService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = new BoardDao();
		int result = bDao.delete(bid);
		model.addAttribute("deleteResult", result);
	}
}
