package com.tj.ex10do.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tj.ex10do.dto.Student;
@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	@RequestMapping(value="inputForm")
	public String inputform() {
		return "inputForm";
	}
	@RequestMapping(value="input")
	public String input(Student student) {
		//student.calculate();
		return "result";
	}
}
