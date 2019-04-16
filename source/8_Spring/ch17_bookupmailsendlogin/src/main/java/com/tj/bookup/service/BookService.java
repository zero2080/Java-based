package com.tj.bookup.service;
import java.util.List;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.bookup.model.Book;
public interface BookService {
	public List<Book> bookListAll();
	public List<Book> bookListPaging(Book book);
	public Book getBook(int bnum);
	public int registerBook(MultipartHttpServletRequest mRequest, Book book);
	//public int registerBook(MultipartHttpServletRequest mRequest); 위나 아래 둘중에 하나
	//public int modifyBook(MultipartHttpServletRequest mRequest, Book book);
	public int modifyBook(MultipartHttpServletRequest mRequest);
	public int cntBook();
}
