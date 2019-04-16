package com.tj.ex12board.service;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.tj.ex12board.dao.BoardDao;
import com.tj.ex12board.dto.BoardDto;
public class BWriteService implements BService {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		BoardDto bDto = (BoardDto)map.get("bDto");
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String bname = bDto.getBname();
		String btitle = bDto.getBtitle();
		String bcontent = bDto.getBcontent();
		String bip = request.getRemoteAddr();
		
		BoardDao bDao = new BoardDao();
		int result = bDao.write(bname, btitle, bcontent, bip);
		model.addAttribute("writeResult", result);
	}
}




