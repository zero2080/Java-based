package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.ProductDto;
public class ProductDao {
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}
	private ProductDao() {}
	private Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = 
				(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection(); // 커넥션 객체 가져오기
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 파라미터로 pName을 받아 dto를 가져오기
	public ProductDto getProduct(String pName) {
		ProductDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM PRODUCT WHERE PNAME=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rs = pstmt.executeQuery();
			if(rs.next()) { // pName 물건이 있는 경우
				int pNo = rs.getInt("pNo");
				int pStock = rs.getInt("pStock");
				dto = new ProductDto(pNo, pName, pStock);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}		
		return dto;
	}
}




















