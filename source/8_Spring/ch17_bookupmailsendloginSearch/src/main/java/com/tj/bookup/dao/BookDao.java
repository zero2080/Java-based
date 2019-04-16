package com.tj.bookup.dao;
import java.util.List;
import com.tj.bookup.model.Book;
public interface BookDao {
	public List<Book> bookListAll();
	public List<Book> bookListPaging(Book book);
	public Book getBook(int bnum);
	public int registerBook(Book book);
	public int modifyBook(Book book);
	public int cntBook(Book book);
}
