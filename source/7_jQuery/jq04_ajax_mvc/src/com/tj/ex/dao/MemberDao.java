package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.ex.dto.MemberDto;
public class MemberDao {
	public static final int EXISTENT    = 0;
	public static final int NONEXISTENT = 1;
	public static final int FAIL    = 0;
	public static final int SUCCESS = 1;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_PW = 0;
	public static final int LOGIN_FAIL_ID = -1;
	private DataSource ds;
	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	// id confirm
	public int mIdConfirm(String mId) {
		int result = EXISTENT;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT;
			}else {
				result = NONEXISTENT;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// join
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER "
				+ "(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmPhoto());
			pstmt.setDate(6, dto.getmBirth());
			pstmt.setString(7, dto.getmAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// login
	public int loginCheck(String mId, String mPw) {
		int result = LOGIN_FAIL_ID;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbmPw = rs.getString("mPw");
				if(dbmPw.equals(mPw)) {
					result = LOGIN_SUCCESS; // 로그인 성공
				}else {
					result = LOGIN_FAIL_PW; // pw 오류
				}
			}else {
				result = LOGIN_FAIL_ID; // id 오류
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// mid로 dto 가져오기
	public MemberDto getMember(String mId) {
		MemberDto member = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID=?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberDto();
				member.setmId(rs.getString("mId"));
				member.setmPw(rs.getString("mPw"));
				member.setmName(rs.getString("mName"));
				member.setmEmail(rs.getString("mEmail"));
				member.setmPhoto(rs.getString("mPhoto"));
				member.setmBirth(rs.getDate("mBirth"));
				member.setmAddress(rs.getString("mAddress"));
				member.setmRdate(rs.getDate("mRdate"));
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return member;
	}
	// modify 
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_MEMBER SET MPW=?, " + 
				"                    MNAME = ?, " + 
				"                    MEMAIL = ?, " + 
				"                    MPHOTO = ?, " + 
				"                    MBIRTH = ?, " + 
				"                    MADDRESS = ? " + 
				"            WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, dto.getmPw());
			pstmt.setString(2, dto.getmName());
			pstmt.setString(3, dto.getmEmail());
			pstmt.setString(4, dto.getmPhoto());
			pstmt.setDate(5, dto.getmBirth());
			pstmt.setString(6, dto.getmAddress());
			pstmt.setString(7, dto.getmId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원수정성공":"회원수정실패");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// 가입한 회원수
	public int getMemberTotCnt() {
		int result = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM MVC_MEMBER";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
	// startRow~endRow 까지 list
	public ArrayList<MemberDto> list(int startRow, int endRow){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM "
				+ " (SELECT ROWNUM RN, A.* FROM "
					+ "(SELECT * FROM MVC_MEMBER ORDER BY MID) A) "
				+ " WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mId     = rs.getString("mId");
				String mPw     = rs.getString("mPw");
				String mName   = rs.getString("mName");
				String mEmail  = rs.getString("mEmail");
				String mPhoto  = rs.getString("mPhoto");
				Date mBirth    = rs.getDate("mBirth");
				String mAddress= rs.getString("mAddress");
				Date mRdate    = rs.getDate("mRdate");
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mPhoto, 
						mBirth, mAddress, mRdate));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
}