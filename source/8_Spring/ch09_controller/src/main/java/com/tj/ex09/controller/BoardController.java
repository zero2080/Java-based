package com.tj.ex09.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tj.ex09.dto.Member;
@Controller
@RequestMapping("board")
public class BoardController {
	// "http://localhost:8181/ex09/board/view"요청경로 처리
	@RequestMapping("view")
	public String view() {
		return "/board/view";
		// "/WEB-INF/views/"+"/board/view"+".jsp"가 뷰가 됨
	}
	@RequestMapping("content")
	public String content(Model model) {
		Member member = new Member("aaa","111");
		model.addAttribute("member", member);
		model.addAttribute("id","bbb");
		model.addAttribute("pw","222");
		return "board/content";
	}
	@RequestMapping("reply")
	public ModelAndView reply() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", "aaa"); // model.addAttribute("id","aaa")와 동일
		Member member = new Member("bbb", "222");
		mav.addObject("member", member);
		mav.setViewName("board/reply");
		return mav;
	}
}










