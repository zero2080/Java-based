package com.tj.ex09.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="member")
public class MemberController {
	@RequestMapping(params="method=join")
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	@RequestMapping(params="method=login")
	public String login() {
		return "member/login";
	}
	@RequestMapping(params="method=logout")
	public String logout() {
		return "member/logout";
	}
	@RequestMapping(params="method=modify")
	public String modify() {
		return "member/modify";
	}
}
