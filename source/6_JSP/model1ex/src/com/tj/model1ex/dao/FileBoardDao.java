package com.tj.model1ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.model1ex.dto.FileBoardDto;
public class FileBoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static FileBoardDao instance = new FileBoardDao();
	private FileBoardDao() {}
	public static FileBoardDao getInstance() {
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
	// 글갯수 가져오기
	public int getFileBoardCnt() {
		int cnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM FILEBOARD";
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
	// startRow부터 endRow까지 글목록 가져오기
	public ArrayList<FileBoardDto> getlistFileBoard(int startRow, int endRow){
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM RN, A.* FROM "
					+ "(SELECT F.*, C.CNAME, C.CEMAIL "
					+ "FROM FILEBOARD F, CUSTOMER C "
					+ "WHERE F.CID=C.CID ORDER BY fref DESC, fre_step) A) "
				+ " WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum        = rs.getInt("fnum");
				String cid      = rs.getString("cid");
				String cname    = rs.getString("cname");
				String cemail   = rs.getString("cemail");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename= rs.getString("ffilename");
				int freadcount  = rs.getInt("freadcount");
				String fpw      = rs.getString("fpw");
				int fref        = rs.getInt("fref");
				int fre_step    = rs.getInt("fre_step");
				int fre_level   = rs.getInt("fre_level");
				String fip      = rs.getString("fip");
				Timestamp frdate= rs.getTimestamp("frdate");
				dtos.add(new FileBoardDto(fnum, cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, fre_step, fre_level, fip, frdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// 글쓰기(원글, 답변글)
	public int insertFileBoard(FileBoardDto dto) {
		// fnum, fref, fre_step, fre_level = 원글(0), 답변글(원글의 정보)
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		if(dto.getFref()!=0) {//답변글의 경우
			preReplyAstep(dto.getFref(), dto.getFre_step()); // step A 단계 수행
			dto.setFre_step(dto.getFre_step()+1);
			dto.setFre_level(dto.getFre_level() + 1);
			String sql = "INSERT INTO FILEBOARD VALUES "
					+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,0,?,?,?,?,?,SYSDATE)";
			// cid(1), fsubject(2), fcontent(3), ffilename(4),freadcount 
			// fpw(5),fref(6), fre_step(7),fre_level(8),fip(9)
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getFsubject());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFfilename());
				pstmt.setString(5, dto.getFpw());
				pstmt.setInt(6, dto.getFref());
				pstmt.setInt(7, dto.getFre_step());
				pstmt.setInt(8, dto.getFre_level());
				pstmt.setString(9, dto.getFip());
				pstmt.executeUpdate();
				result = SUCCESS;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {System.out.println(e.getMessage());}
			}
		}else {//원글인 경우
			String sql = "INSERT INTO FILEBOARD VALUES "
					+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,0,?,"
					+ "fileboard_seq.CURRVAL, 0,0,?,SYSDATE)";
				// cid(1), fsubject(2), fcontent(3), ffilename(4),
				// freadcount, fpw(5), fref, fre_step,fre_level,fip(6)
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getFsubject());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFfilename());
				pstmt.setString(5, dto.getFpw());
				pstmt.setString(6, dto.getFip());
				pstmt.executeUpdate();
				result = SUCCESS;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {System.out.println(e.getMessage());}
			}
		}
		return result;
	}
	// 답변글 쓰기전 step A
	public void preReplyAstep(int fref, int fre_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD "
			+ "SET FRE_STEP = FRE_STEP+1 WHERE FREF=? AND FRE_STEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fref);
			pstmt.setInt(2, fre_step);
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
	// 조회수 올리기
	public void readCountUp(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 "
				+ "WHERE FNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {	System.out.println(e.getMessage());}
		}
	}
	// 글번호로 글 상세내용(dto) 가져오기
	public FileBoardDto getFileBoardOneLine(int fnum) {
		FileBoardDto dto = null;
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rs = null;
		String sql = "SELECT F.*, C.CNAME, C.CEMAIL "
				+ "FROM FILEBOARD F, CUSTOMER C "
				+ "WHERE F.CID=C.CID AND F.FNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new FileBoardDto();
				dto.setFnum(fnum);
				dto.setCid(rs.getString("cid"));
				dto.setCname(rs.getString("cname"));
				dto.setCemail(rs.getString("cemail"));
				dto.setFsubject(rs.getString("fsubject"));
				dto.setFcontent(rs.getString("fcontent"));
				dto.setFfilename(rs.getString("ffilename"));
				dto.setFreadcount(rs.getInt("freadcount"));
				dto.setFpw(rs.getString("fpw"));
				dto.setFref(rs.getInt("fref"));
				dto.setFre_step(rs.getInt("fre_step"));
				dto.setFre_level(rs.getInt("fre_level"));
				dto.setFip(rs.getString("fip"));
				dto.setFrdate(rs.getTimestamp("frdate"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null)  conn.close();
			} catch (Exception e) {System.out.println(e.getMessage()); }
		}
		return dto;
	}
	// 글 수정
	public int updateFileBoard(FileBoardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD "
				+ "SET FSUBJECT = ?, "
					+ "FCONTENT = ?, "
					+ "FFILENAME = ?, "
					+ "FPW = ?, "
					+ "FIP = ? "
				+ "WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFcontent());
			pstmt.setString(3, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null)	pstmt.close();
				if (conn != null)	conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}

		return result;
	}
	// 글 삭제(삭제시 비번과 글번호 필요)
	public int deleteFileBoard(int fnum, String fpw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FNUM=? AND FPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			int tempResult = pstmt.executeUpdate();
			if(tempResult>0) result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	}
}