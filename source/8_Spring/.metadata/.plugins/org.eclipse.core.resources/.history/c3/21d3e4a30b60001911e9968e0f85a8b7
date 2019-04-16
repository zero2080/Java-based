package com.tj.bookup.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj.bookup.model.Member;
import com.tj.bookup.service.MemberService;
@Controller
@RequestMapping("member")
// member.do?method=join&mid=aaa
public class MemberController {
	@Autowired
	private MemberService mService;
	@RequestMapping(params="method=joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping(params="method=idConfirm")
	public String idConfirm(String mid, Model model) {
		int result = mService.idConfirm(mid);
		model.addAttribute("result", result);
		return "member/idConfirm";
	}
	@RequestMapping(params="method=join")
	public String join(Member member, Model model, HttpSession httpSession) {
		mService.joinMember(member);
		httpSession.setAttribute("mid", member.getMid());
		return "redirect:member.do?method=loginForm";
	}
	@RequestMapping(params="method=loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login")
	public String login(String mid, String mpw, Model model,
			HttpSession httpSession) {
		String result = mService.loginCheck(mid, mpw, httpSession);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	@RequestMapping(params="method=logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(Model model, HttpSession httpSession) {
		Member member = (Member)httpSession.getAttribute("member");
		model.addAttribute("modifyMember", member);
		return "member/modifyForm";
	}
	@RequestMapping(params="method=modify")
	public String modify(Member member, Model model, HttpSession httpSession) {
		int result = mService.modifyMember(member);
		if(result==1) {//수정성공
			httpSession.setAttribute("member", member);
			model.addAttribute("modifyResult", result);
			return "forward:main.do";
		}else {
			return "member.do?method=modifyForm";
		}
	}
}














