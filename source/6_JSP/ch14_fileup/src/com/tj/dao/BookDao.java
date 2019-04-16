package com.tj.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.BookDto;
public class BookDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	private BookDao() {}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = 
					(DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 전체 등록 책 갯수
	public int getBookCnt() {
		int cnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM BOOK";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null)  rs.close();
				if(pstmt!=null)  pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return cnt;
	}
	// 전체 책 ArrayList에 담아 return
	public ArrayList<BookDto> listBook(){
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOOK ORDER BY bTitle";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				BookDto dto = new BookDto();
				dto.setBid(rs.getInt("bid"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBprice(rs.getInt("bprice"));
				dto.setBimage1(rs.getString("bimage1"));
				dto.setBimage2(rs.getString("bimage2"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdiscount(rs.getInt("bdiscount"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null)  rs.close();
				if(pstmt!=null)  pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// startRow~endRow까지 책을 ArrayList에 담아 return
	public ArrayList<BookDto> listBook(int startRow, int endRow){
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM "
					+ "(SELECT ROWNUM RN, A.* FROM "
						+ "(SELECT * FROM BOOK ORDER BY bTitle) A) "
				+ "WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs    = pstmt.executeQuery();
			while(rs.next()) {
				BookDto dto = new BookDto();
				dto.setBid(rs.getInt("bid"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBprice(rs.getInt("bprice"));
				dto.setBimage1(rs.getString("bimage1"));
				dto.setBimage2(rs.getString("bimage2"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdiscount(rs.getInt("bdiscount"));
				dtos.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null)  rs.close();
				if(pstmt!=null)  pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// 책 등록(추가)
	public int insertBook(BookDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			conn = getConnection();
			if(dto.getBimage1()!=null && dto.getBimage2()!=null) {
				sql = "INSERT INTO BOOK "
				+ "(bId, bTitle, bPrice, bImage1, bImage2, bContent, bDiscount) "
				+ " VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBtitle());
				pstmt.setInt(2, dto.getBprice());
				pstmt.setString(3, dto.getBimage1());
				pstmt.setString(4, dto.getBimage2());
				pstmt.setString(5, dto.getBcontent());
				pstmt.setInt(6, dto.getBdiscount());
				result = pstmt.executeUpdate();
			}else if(dto.getBimage1()!=null && dto.getBimage2()==null) {
				sql = "INSERT INTO BOOK "
				  + "(bId, bTitle, bPrice, bImage1, bContent, bDiscount) " 
				  +	" VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBtitle());
				pstmt.setInt(2, dto.getBprice());
				pstmt.setString(3, dto.getBimage1());
				pstmt.setString(4, dto.getBcontent());
				pstmt.setInt(5, dto.getBdiscount());
				result = pstmt.executeUpdate();
			}else if(dto.getBimage1()==null && dto.getBimage2()!=null) {
				sql = "INSERT INTO BOOK "
				 + "(bId, bTitle, bPrice, bImage2, bContent, bDiscount) " 
				 +	" VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBtitle());
				pstmt.setInt(2, dto.getBprice());
				pstmt.setString(3, dto.getBimage2());
				pstmt.setString(4, dto.getBcontent());
				pstmt.setInt(5, dto.getBdiscount());
				result = pstmt.executeUpdate();
			}else if(dto.getBimage1()==null && dto.getBimage2()==null) {
				sql = "INSERT INTO BOOK "
				  + "(bId, bTitle, bPrice, bContent, bDiscount) " 
				  + " VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getBtitle());
				pstmt.setInt(2, dto.getBprice());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setInt(4, dto.getBdiscount());
				result = pstmt.executeUpdate();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null)  pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
}






















