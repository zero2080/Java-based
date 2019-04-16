package com.tj.bookup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tj.bookup.dao.BookDao;
@Controller
public class MainController {
	@Autowired
	private BookDao bookDao;
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("main", bookDao.bookListAll());
		return "main/main";
	}
}