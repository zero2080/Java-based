package com.tj.ex16_1.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tj.ex16_1.model.Dept;
import com.tj.ex16_1.model.Emp;
import com.tj.ex16_1.service.EmpService;
@Controller
public class EmpController {
	@Autowired
	private EmpService eService;
	@ModelAttribute("deptList")
	public List<Dept> deptList(){
		return eService.deptList();
	}
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String emp(@ModelAttribute("search") Emp search, Model model) {
		// emp.do?ename=S&job=E&deptno=20
		model.addAttribute("empList", eService.empList(search));
		return "emp";
	}
}
