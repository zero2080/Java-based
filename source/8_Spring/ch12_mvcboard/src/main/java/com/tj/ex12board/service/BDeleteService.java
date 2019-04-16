package com.tj.ex12board.service;
import java.util.Map;
import org.springframework.ui.Model;
import com.tj.ex12board.dao.BoardDao;
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
