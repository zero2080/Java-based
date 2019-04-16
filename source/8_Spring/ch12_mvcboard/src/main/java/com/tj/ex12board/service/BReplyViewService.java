package com.tj.ex12board.service;
import java.util.Map;
import org.springframework.ui.Model;
import com.tj.ex12board.dao.BoardDao;
import com.tj.ex12board.dto.BoardDto;
public class BReplyViewService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int bid = (Integer)map.get("bid");
		BoardDao bDao = new BoardDao();
		BoardDto bDto = bDao.modifyView_replyView(bid);
		model.addAttribute("reply_view", bDto);
	}
}
