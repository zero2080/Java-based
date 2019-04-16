package com.tj.member;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class MemberDao {
	public static final int FAIL = 0; // 실패 (회원가입, 정보수정)
	public static final int SUCCESS = 1; // 성공(회원가입, 정보수정)
	public static final int MEMBER_NONEXISTENT = 0; // 없는 ID
	public static final int MEMBER_EXISTENT    = 1; // 있는 ID
	public static final int LOGIN_FAIL_ID = -1; // 로그인오류(id)
	public static final int LOGIN_FAIL_PW = 0;  // 로그인오류(pw)
	public static final int LOGIN_SUCCESS = 1;  // 로그인성공
	
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
	// 1. 회원가입시 id 중복체크
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String     sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 있는 회원 ID
				result = MEMBER_EXISTENT;
			}else { // 없는 ID
				result = MEMBER_NONEXISTENT;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (Exception e) {}
		}
		return result;
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
			pstmt.setTimestamp(5, dto.getBirth());
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
	// 3. 로그인
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // id를 맞게 친 경우
				String dbPw = rs.getString("pw"); // DB에 저장된 진짜 pw
				if(dbPw.equals(pw)) {
					result = LOGIN_SUCCESS; //pw도 맞게 친 경우
				}else {
					result = LOGIN_FAIL_PW; //pw를 틀리게 친 경우
				}
			}else { // id를 틀리게 친 경우
				result = LOGIN_FAIL_ID;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		
		return result;
	}
	// 4. id로 회원정보 모두 가져오기
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String 	pw = rs.getString("pw");
				String 	name = rs.getString("name");
				String 	email = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Date   	rDate = rs.getDate("rDate");
				String  address = rs.getString("address");
				dto = new MemberDto(id, pw, name, email, birth, rDate, address);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dto;
	}
	// 5. 회원정보 수정
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?, "
							+ "NAME=?, "
							+ "EMAIL=?, "
							+ "BIRTH=?, "
							+ "ADDRESS=?"
						+ " WHERE ID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setTimestamp(4, dto.getBirth());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			result = pstmt.executeUpdate();
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





















