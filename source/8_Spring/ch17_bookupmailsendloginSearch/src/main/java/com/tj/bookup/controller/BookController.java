package com.tj.bookup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.bookup.model.Book;
import com.tj.bookup.service.BookService;
import com.tj.bookup.service.Paging;
@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(params="method=registerForm", method=RequestMethod.GET)
	public String registerBook() {
		return "book/registerForm";
	}
	@RequestMapping(params="method=register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest) {
		bookService.registerBook(mRequest);
		return "book/registerForm";
	}
	@RequestMapping(params="method=view", method=RequestMethod.GET)
	public String view(Book book, String pageNum, Model model) {
		int cntBook = bookService.cntBook(book);
		Paging paging = new Paging(cntBook, pageNum, 3, 2); // 이 서비스는 pageSize = 3, blockSize는 5로 함
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		model.addAttribute("view", bookService.bookListPaging(book));
		model.addAttribute("paging", paging);
		return "book/view";
	}
	@RequestMapping(params="method=detail", method=RequestMethod.GET)
	public String detail(int bnum, Model model) {
		model.addAttribute("detail", bookService.getBook(bnum));
		return "book/detail";
	}
	@RequestMapping(params="method=modifyForm", method=RequestMethod.GET)
	public String modifyForm(int bnum, String pageNum, Model model) {
		model.addAttribute("detail", bookService.getBook(bnum));
		return "book/modifyForm";
	}
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modify(MultipartHttpServletRequest mRequest, String pageNum) {
		bookService.modifyBook(mRequest);
		return "redirect:book.do?method=view&pageNum="+pageNum;
	}
}
