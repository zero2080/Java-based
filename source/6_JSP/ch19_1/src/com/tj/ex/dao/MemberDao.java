package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.ex.dto.MemberDto;
public class MemberDao {
	public static final int FAIL = 0; // 실패 (회원가입, 정보수정)
	public static final int SUCCESS = 1; // 성공(회원가입, 정보수정)
	private static MemberDao instance = new MemberDao();;
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {}
	// getConnection() : conn객체 얻어오기
	private Connection getConnection() throws SQLException {
		Connection conn=null;
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
	// 1. 회원리스트 가져오기
	public ArrayList<MemberDto> getMembersAll(){
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String 	id     = rs.getString("id");
				String 	pw     = rs.getString("pw");
				String 	name   = rs.getString("name");
				String 	email  = rs.getString("email");
				String  birth  = rs.getString("birth");
				Date   	rDate  = rs.getDate("rDate");
				String  address= rs.getString("address");
				members.add(new MemberDto(id, pw, name, email, 
						birth, rDate, address));
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
		return members;
		
	}
	// 2. 회원가입
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER "
				+ "(ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS) "
				+ "VALUES (?,?,?,?,?, SYSDATE, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
}