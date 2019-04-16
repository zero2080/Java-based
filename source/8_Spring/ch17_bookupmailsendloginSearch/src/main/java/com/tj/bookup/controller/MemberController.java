package com.tj.bookup.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tj.bookup.model.Member;
import com.tj.bookup.service.MemberService;
@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(params="method=joinForm", method=RequestMethod.GET)
	public String joinFormMember() {
		return "member/joinForm";
	}
	@RequestMapping(params="method=join")
	public String joinMember(Member member, String addDetail, Model model, HttpSession httpSession) {
		member.setMaddr(member.getMaddr()+" " + addDetail);
		memberService.joinMember(member);
		httpSession.setAttribute("mid", member.getMid());
		return "redirect:member.do?method=loginForm";
	}
	@RequestMapping(params="method=idConfirm")
	public String idConfirm(String mid, Model model) {
		int result = memberService.idConfirm(mid);
		model.addAttribute("result", result);
		return "member/idConfirm";
	}
	@RequestMapping(params="method=loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login")
	public String login(String mid, String mpw, HttpSession httpSession, Model model) {
		String result = memberService.loginCheck(mid, mpw, httpSession);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result",result);
			return "forward:member.do?method=loginForm";
		}
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(Model model, HttpSession httpSession) {
		String mid = ((Member)httpSession.getAttribute("member")).getMid();
		model.addAttribute("modifyMember", memberService.getMember(mid));
		return "member/modifyForm"; 
	}
	@RequestMapping(params="method=modify")
	public String modify(Member member, Model model, HttpSession httpSession) {
		System.out.println("컨트롤러 : "+member.toString());
		int result = memberService.modifyMember(member);
		if(result>0) {
			model.addAttribute("modifyResult", result);
			httpSession.setAttribute("member", member);
			return "redirect:main.do";
		}else {
			return "member.do?method=modifyForm";
		}
	}
	@RequestMapping(params="method=logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}
}
