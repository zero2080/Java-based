package com.tj.ex11rm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ConfirmController {
	@RequestMapping(value="confirm", method=RequestMethod.GET)
	public String confirm() {
		return "confirm";
	}
	@RequestMapping(value="studentConfirm", method=RequestMethod.POST)
	public String studentConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			return "forward:studentOk.do";//model값 유지
		}else {
			return "redirect:studentNg.do";//model값 reset
		}
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentOk", method=RequestMethod.POST)
	public ModelAndView studentOk(ModelAndView mav) {
		mav.setViewName("studentOk");
		return mav;
	}
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.POST)
	public ModelAndView studentNg(ModelAndView mav) {
		mav.setViewName("studentNg");
		return mav;
	}
	@RequestMapping(value="goNaver", method=RequestMethod.GET)
	public String goNaver() {
		return "redirect:http://www.naver.com";
	}
}








