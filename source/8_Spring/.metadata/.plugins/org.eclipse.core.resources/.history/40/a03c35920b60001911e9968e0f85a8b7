package com.tj.bookup.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tj.bookup.model.Book;
@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Book> bookListAll() {
		return sessionTemplate.selectList("bookListAll");
	}
	@Override
	public List<Book> bookListPaging(Book book) {
		return sessionTemplate.selectList("bookListPaging", book);
	}
	@Override
	public Book getBook(int bnum) {
		return sessionTemplate.selectOne("getBook", bnum);
	}
	@Override
	public int registerBook(Book book) {
		return sessionTemplate.insert("registerBook", book);
	}
	@Override
	public int modifyBook(Book book) {
		return sessionTemplate.update("modifyBook", book);
	}
	@Override
	public int cntBook() {
		return sessionTemplate.selectOne("cntBook");
	}
}