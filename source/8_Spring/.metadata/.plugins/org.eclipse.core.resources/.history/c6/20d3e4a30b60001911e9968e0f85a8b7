package com.tj.bookup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tj.bookup.model.Book;
import com.tj.bookup.service.BookService;
import com.tj.bookup.service.Paging;
@Controller
@RequestMapping("book")
// book.do?method=register
public class BookController {
	@Autowired
	private BookService bService;
	@RequestMapping(params="method=registerForm")
	public String registerForm() {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register")
	public String register(Book book, MultipartHttpServletRequest mRequest) {
		bService.registerBook(mRequest, book);
		return "book/registerForm";
	}
	@RequestMapping(params="method=view")
	public String view(Book book, String pageNum, Model model) {
		Paging paging = new Paging(bService.cntBook(), pageNum, 5, 3);
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		model.addAttribute("view", bService.bookListPaging(book));
		model.addAttribute("paging", paging);
		return "book/view";
	}
	@RequestMapping(params="method=detail")
	public String detail(int bnum, Model model) {
		model.addAttribute("detail", bService.getBook(bnum));
		return "book/detail";
	}
	@RequestMapping(params="method=modifyForm")
	public String modifyForm(int bnum, String pageNum, Model model) {
		model.addAttribute("detail", bService.getBook(bnum));
		return "book/modifyForm";
	}
	@RequestMapping(params="method=modify")
	public String modify(MultipartHttpServletRequest mRequest, String pageNum) {
		bService.modifyBook(mRequest);
		return "redirect:book.do?method=view&pageNum="+pageNum;
	}
}











