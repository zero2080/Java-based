package com.tj.ex16_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ex16_1.dao.DeptDao;
import com.tj.ex16_1.dao.EmpDao;
import com.tj.ex16_1.model.Emp;
import com.tj.ex16_1.service.EmpService;
@Controller
public class HomeController {
	@Autowired
	private EmpService eService;
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("deptList", eService.deptList());
		Emp emp = new Emp();
		emp.setEname("S");
		model.addAttribute("empList", eService.empList(emp));
		model.addAttribute("greeting", "안녕하세요 myBatis");
		return "home";
	}
}