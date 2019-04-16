package com.tj.ex13.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tj.ex13.dto.BoardDto;
import com.tj.ex13.service.*;
import com.tj.ex13.util.Constant;
@Controller
public class BoardController {
	private BService service;
	private int writable;
	
	private JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model) {
		// list.do
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="list", method=RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		// list.do
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="content_view", method=RequestMethod.GET)
	public String content_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content_view";
	}
	@RequestMapping(value="write_view", method=RequestMethod.GET)
	public String write_view() {
		writable = 1;
		return "mvcboard/write_view";
	}
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto, 
			HttpServletRequest request, Model model) {
		if(writable==1) {
			model.addAttribute("request", request);
			service = new BWriteService();
			service.execute(model);
			writable = 0;
		}
		return "forward:list.do";
	}
	@RequestMapping(value="modify_view", method=RequestMethod.GET)
	public String modify_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BModifyViewService();
		service.execute(model);
		return "mvcboard/modify_view";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("bDto") BoardDto boardDto,
		HttpServletRequest request,	Model model) {
		model.addAttribute("request", request);
		service = new BModifyService();
		service.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BDeleteService();
		service.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="reply_view", method=RequestMethod.GET)
	public String reply_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BReplyViewService();
		service.execute(model);
		return "mvcboard/reply_view";
	}
	@RequestMapping(value="reply", method=RequestMethod.POST)
	public String reply(BoardDto boardDto,
		HttpServletRequest request,	Model model) {
		model.addAttribute("request", request);
		service = new BReplyService();
		service.execute(model);
		return "forward:list.do";
	}
}












