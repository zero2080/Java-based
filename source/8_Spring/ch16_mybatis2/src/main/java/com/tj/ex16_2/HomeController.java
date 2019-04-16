package com.tj.ex16_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	@Autowired
	private DriverManagerDataSource dataSource;
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("test", dataSource.getUsername());
		return "home";
	}
}
