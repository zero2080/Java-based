package com.tj.ex11rm.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {
	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model, 
			HttpServletRequest request) {
		System.out.println("GET방식으로 들어옴");
		model.addAttribute("id", id);
		String method = request.getMethod();
		model.addAttribute("method", method);
		return "studentID";
	}
	@RequestMapping(value="student", method=RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav,
			HttpServletRequest request) {
		System.out.println("POST방식으로 들어옴");
		//ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		String method = request.getMethod();
		mav.addObject("method", method);
		mav.setViewName("studentID");
		return mav;
	}
}










