package com.tj.bookup.service;
import java.util.List;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.bookup.model.Book;
public interface BookService {
	public List<Book> bookListAll();
	public List<Book> bookListPaging(Book book);
	public Book getBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest);
	public int modifyBook(MultipartHttpServletRequest mRequest);
	public int cntBook(Book book);
}
