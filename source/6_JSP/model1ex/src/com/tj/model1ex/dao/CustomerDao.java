package com.tj.model1ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.model1ex.dto.CustomerDto;
public class CustomerDao {
	public static final int FAIL = 0; // 실패 (회원가입, 정보수정)
	public static final int SUCCESS = 1; // 성공(회원가입, 정보수정)
	public static final int MEMBER_NONEXISTENT = 0; // 없는 ID
	public static final int MEMBER_EXISTENT    = 1; // 있는 ID
	public static final int LOGIN_FAIL_ID = -1; // 로그인오류(id)
	public static final int LOGIN_FAIL_PW = 0;  // 로그인오류(pw)
	public static final int LOGIN_SUCCESS = 1;  // 로그인성공
	private static CustomerDao instance = new CustomerDao();
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		return instance;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = 
			 (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	// 가입한 회원 수 가져오기
	public int getCustomerCnt() {
		int cnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return cnt;
	}
	// startRow부터 endRow까지 회원list가져오기
	public ArrayList<CustomerDto> getlistCustomer(int startRow, int endRow){
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM " + 
			"    (SELECT ROWNUM RN, A.* FROM" + 
			"        (SELECT * FROM CUSTOMER ORDER BY CID) A) " + 
			"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cid    = rs.getString("cid");
				String cpw    = rs.getString("cpw");
				String cname  = rs.getString("cname");
				String ctel   = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String cgender= rs.getString("cgender");
				String caddr  = rs.getString("caddr");
				dtos.add(new CustomerDto(cid, cpw, cname, ctel, cemail, cgender, caddr));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// 회원가입전 id 중복체크
	public int confirmId(String cid) {
		int result = MEMBER_EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = MEMBER_EXISTENT;
			}else {
				result = MEMBER_NONEXISTENT;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// 회원가입하기
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER "
				+ " (cid, cpw, cname, ctel, cemail, cgender, caddr)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCgender());
			pstmt.setString(7, dto.getCaddr());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// 로그인체크
	public int loginCheck(String cid, String cpw) {
		int result = LOGIN_FAIL_ID;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPw = rs.getString("cpw");
				if(dbPw.equals(cpw)) {
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			}else {
				result = LOGIN_FAIL_ID;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// 회원정보 수정시 id로 dto 반환
	public CustomerDto getCustomer(String cid) {
		CustomerDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String cpw    = rs.getString("cpw");
				String cname  = rs.getString("cname");
				String ctel   = rs.getString("ctel");
				String cemail = rs.getString("cemail");
				String cgender= rs.getString("cgender");
				String caddr  = rs.getString("caddr");
				dto = new CustomerDto(cid, cpw, cname, ctel, cemail, cgender, caddr);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dto;
	}
	// 회원정보수정
	public int updateCustomer(CustomerDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER "
				+ "SET CPW=?, "
					+ "CNAME=?,"
					+ "CTEL=?, "
					+ "CEMAIL=?, "
					+ "CGENDER=?, "
					+ "CADDR=? "
				+ "WHERE CID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCpw());
			pstmt.setString(2, dto.getCname());
			pstmt.setString(3, dto.getCtel());
			pstmt.setString(4, dto.getCemail());
			pstmt.setString(5, dto.getCgender());
			pstmt.setString(6, dto.getCaddr());
			pstmt.setString(7, dto.getCid());
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
}