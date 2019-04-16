package com.tj.ex10form.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.ex10form.dto.MemberInfo;
@Controller
public class MyController {
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("테스트1");list.add("테스트2");list.add("테스트3");
		return list;
	}
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@RequestMapping("/")
	public String input(/*Model model*/) {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("테스트1");list.add("테스트2");list.add("테스트3");
//		model.addAttribute("list",list);
		return "input";
	}
	@RequestMapping("member/join1")
	public String join1(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	@RequestMapping("member/join2")
	public String join2(@RequestParam("name") String name,
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("age") int age,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	@RequestMapping("member/join3")
	public String join3(String name, String id, String pw,
			int age, String email,String address,
			Model model) {
		MemberInfo memberInfo = new MemberInfo(name, id, pw, age, email, address);
		model.addAttribute("memberInfo", memberInfo);
		return "member/result3";
	}
	@RequestMapping("member/join4") /* 데이터커맨드 = 매개변수없는생성자,setters*/
	public String join4(@ModelAttribute("member") MemberInfo memberInfo) {
		return "member/result4";
	}
	/*
	 ? : 1개 이상의 글자
	 * : 0개 이상의 글자
	 ** : 0개 이상의 디렉토리 경로 
	 ex : student/aaa
	*/
	/* JSP에서의 방법
	@RequestMapping("student/*")
	public String student(HttpServletRequest request, Model model) {
		String uri = request.getRequestURI(); // "/ex10form/student/aaa"
		String id = uri.substring(uri.lastIndexOf("/")+1);
		model.addAttribute("id", id);
		return "member/studentResult";
	}*/
	@RequestMapping("student/{id}")
	public String student(@PathVariable String id, Model model) {
		model.addAttribute("id",id);
		return "member/studentResult";
	}
}













