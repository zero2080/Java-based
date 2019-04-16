package com.tj.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
// 회원리스트(memberSelectAll), 회원가입(memberInsert)
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.MemberDto;
public class MemberDao {
	private static MemberDao instance;
	private DataSource dataSource;
	public static MemberDao getInstance() {
		if(instance==null) {
			instance = new MemberDao();
		}
		return instance;
	}	
	private MemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}	
	public ArrayList<MemberDto> memberSelectAll(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		// sql 문실행결과를 dtos에 담는다
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT * FROM MEMBER ORDER BY ID";
		try {
			conn = dataSource.getConnection();//2단계
			stmt = conn.createStatement();//3단계
			rs   = stmt.executeQuery(sql); // 4+5단계
			while(rs.next()) { // 6단계
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				dtos.add(new MemberDto(name, id, pw, 
						phone1, phone2, phone3, gender));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7단계
				if(rs!=null)  rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) { }
		}
		return dtos;
	}
	public int memberInsert(MemberDto dto) {
		int result = 0;
		// sql 문 실행결과를 result에 담는다
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?)";
										//name, id, pw, phone1~3, gender
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			result = pstmt.executeUpdate();
			System.out.println(result>0? "회원가입성공":"회원가입실패");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {}
		}
		return result;
	}
}














