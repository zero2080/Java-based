package com.tj.ex12board.service;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.tj.ex12board.dao.BoardDao;
import com.tj.ex12board.dto.BoardDto;
public class BReplyService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		BoardDto bDto = (BoardDto)map.get("boardDto"); 
		String bname = bDto.getBname();
		String btitle = bDto.getBtitle();
		String bcontent = bDto.getBcontent();
		String bip = request.getRemoteAddr();
		int bgroup = bDto.getBgroup();
		int bstep = bDto.getBstep();
		int bindent = bDto.getBindent();
		BoardDao bDao = new BoardDao();
		int result = bDao.reply(bname, btitle, bcontent, bip, bgroup, bstep, bindent);
		model.addAttribute("replyResult", result);
	}
}













