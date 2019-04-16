package com.tj.ex16_2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tj.ex16_2.model.Emp;
import com.tj.ex16_2.model.EmpDept;
import com.tj.ex16_2.service.EmpService;
import com.tj.ex16_2.service.Paging;
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value="list")
	public String list(String pageNum, Model model) {
		model.addAttribute("list", empService.empList(pageNum));
		Paging paging = new Paging(empService.total(), pageNum, 10, 10);
		model.addAttribute("paging", paging);
		return "list";
	}
	@RequestMapping(value="joinlist")
	public String joinlist(String pageNum, EmpDept empDept, Model model) {
		// joinlist.do?pageNum=2
		Paging paging = new Paging(empService.total(), pageNum, 10, 10);
		empDept.setStartRow(paging.getStartRow());
		empDept.setEndRow(paging.getEndRow());
		model.addAttribute("joinlist", empService.empDeptList(empDept));
		model.addAttribute("paging", paging);
		return "joinlist";
	}
	@RequestMapping(value="insert50")
	public String insert50() {
		empService.insert50();
		return "redirect:joinlist.do";
	}
	@RequestMapping(value="detail")
	public String detail(int empno, Model model) {
		model.addAttribute("detail", empService.detail(empno));
		return "detail";
	}
	@RequestMapping(value="writeForm")
	public String writeForm(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "writeForm";
	}
	@RequestMapping(value="confirmNo")
	public String confirmNo(int empno, Model model) {
		if(empService.detail(empno)==null) {//없는 사번
			model.addAttribute("msg", "사용가능한 사번");
		}else {// 중복된 사번
			model.addAttribute("msg", "중복된 사번");
		}
		return "forward:writeForm.do";
	}
	@RequestMapping(value="write")
	public String write(Emp emp, Model model) {
		try {
			empService.insert(emp);
		}catch (Exception e) {
			model.addAttribute("writeResult","직원등록 실패");
			return "forward:writeForm.do";
		}
		return "redirect:joinlist.do";
	}
	@RequestMapping(value="delete")
	public String delete(int empno, String pageNum) {
		empService.delete(empno);
		return "redirect:joinlist.do?pageNum="+pageNum;
	}
	@RequestMapping(value="updateForm")
	public String updateForm(int empno, Model model) {
		model.addAttribute("updateForm", empService.detail(empno));
		return "updateForm";
	}
	@RequestMapping(value="update")
	public String update(Emp emp, String pageNum) {
		empService.update(emp);
		return "redirect:joinlist.do?pageNum="+pageNum;
	}
}
















