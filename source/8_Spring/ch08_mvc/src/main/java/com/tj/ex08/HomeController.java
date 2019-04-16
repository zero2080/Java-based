package com.tj.ex08;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("serverTime", "2019년03월25일 오후 1시" );
		return "home";
	}
	@RequestMapping("/main")
	public String main() {
		return "main/main"; // 뷰=>"/WEB-INF/views/main/main.jsp"
	}	
}














