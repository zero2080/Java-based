package com.tj.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.dto.BoardDto;
public class BoardDao {
	public static final int SUCCESS = 1;
	public static final int FAIL    = 0;
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao() {}
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
	// 글갯수 가져오는 getBoardTotalCnt()
	public int getBoardTotalCnt() {
		int totCnt = 0;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT COUNT(*) FROM BOARD";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totCnt = rs.getInt(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return totCnt;
	}
	// 글목록 listBoard()
	public ArrayList<BoardDto> listBoard(){
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num       = rs.getInt("num");
				String writer = rs.getString("writer");
				String subject= rs.getString("subject");
				String content= rs.getString("content");
				String email  = rs.getString("email");
				int readCount = rs.getInt("readCount");
				String pw     = rs.getString("pw");
				int ref       = rs.getInt("ref");
				int re_step   = rs.getInt("re_step");
				int re_level  = rs.getInt("re_level");
				String ip     = rs.getString("ip");
				Timestamp rDate=rs.getTimestamp("rDate");
				dtos.add(new BoardDto(num, writer, subject, content, email, 
						   readCount, pw, ref, re_step, re_level, ip, rDate));
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
		return dtos;
	}
	// 글목록 listBoard(startRow, endRow)
		public ArrayList<BoardDto> listBoard(int startRow, int endRow){
			ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
			Connection        conn  = null;
			PreparedStatement pstmt = null;
			ResultSet         rs    = null;
			String sql = "SELECT * FROM " + 
				  " (SELECT ROWNUM RN, A.* " + 
				  "  FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A) " + 
				" WHERE RN BETWEEN ? AND ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					int num       = rs.getInt("num");
					String writer = rs.getString("writer");
					String subject= rs.getString("subject");
					String content= rs.getString("content");
					String email  = rs.getString("email");
					int readCount = rs.getInt("readCount");
					String pw     = rs.getString("pw");
					int ref       = rs.getInt("ref");
					int re_step   = rs.getInt("re_step");
					int re_level  = rs.getInt("re_level");
					String ip     = rs.getString("ip");
					Timestamp rDate=rs.getTimestamp("rDate");
					dtos.add(new BoardDto(num, writer, subject, content, email, 
							   readCount, pw, ref, re_step, re_level, ip, rDate));
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
			return dtos;
		}
	// 글쓰기 insertBoard(dto)
	public int insertBoard(BoardDto dto) {
		//num, ref != 0일 경우 답변글 처리(num, ref, re_step, re_level:원글)
		//                        (subject, content, pw, email, wrtier:답변글)
		//                step ⓐ update board set re_step = re_step+1
		//							where ref=dto.ref and re_step>dto.re_step;
		//                dto.re_step +1, re_level+1
		//num, ref == 0
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			conn = getConnection();
			if(dto.getRef()!=0){
				String stepASql = "UPDATE BOARD SET RE_STEP = RE_STEP+1 "
						+ "WHERE REF=? AND RE_STEP>?";
				pstmt = conn.prepareStatement(stepASql);
				pstmt.setInt(1, dto.getRef());
				pstmt.setInt(2, dto.getRe_step());
				pstmt.executeUpdate();
				pstmt.close();
				dto.setRe_step(dto.getRe_step()+1); // re_step 하나 증가
				dto.setRe_level(dto.getRe_level()+1);//re_level 하나 증가
			}
			
			String getNumSql = "SELECT NVL(MAX(NUM),0)+1 FROM BOARD";
			pstmt = conn.prepareStatement(getNumSql);
			rs    = pstmt.executeQuery();
			rs.next();
			int num = rs.getInt(1); // 새로운 글의 글번호
			rs.close();
			pstmt.close();
			
			String insertSql = 
			  "INSERT INTO BOARD "
				+ " (NUM, WRITER, SUBJECT, CONTENT, EMAIL, READCOUNT, PW, "
				+ " REF, RE_STEP, RE_LEVEL, IP, RDATE) "
			  + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setInt(6, dto.getReadCount());
			pstmt.setString(7, dto.getPw());
			if(dto.getRef()==0) { // 원글일 경우 ref에 num
				dto.setRef(num);
			}			
			pstmt.setInt(8, dto.getRef());
			pstmt.setInt(9, dto.getRe_step());
			pstmt.setInt(10, dto.getRe_level());
			pstmt.setString(11, dto.getIp());
			pstmt.executeUpdate();
			result = SUCCESS;
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
	// 글번호로 글한줄 가져오기 getBoardOneLine(num)
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String writer = rs.getString("writer");
				String subject= rs.getString("subject");
				String content= rs.getString("content");
				String email  = rs.getString("email");
				int readCount = rs.getInt("readCount");
				String pw     = rs.getString("pw");
				int ref       = rs.getInt("ref");
				int re_step   = rs.getInt("re_step");
				int re_level  = rs.getInt("re_level");
				String ip     = rs.getString("ip");
				Timestamp rDate=rs.getTimestamp("rDate");
				dto = new BoardDto(num, writer, subject, content, email, 
							readCount, pw, ref, re_step, re_level, ip, rDate);
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
	public BoardDto getBoardOneLine(String num) {
		BoardDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOARD WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String writer = rs.getString("writer");
				String subject= rs.getString("subject");
				String content= rs.getString("content");
				String email  = rs.getString("email");
				int readCount = rs.getInt("readCount");
				String pw     = rs.getString("pw");
				int ref       = rs.getInt("ref");
				int re_step   = rs.getInt("re_step");
				int re_level  = rs.getInt("re_level");
				String ip     = rs.getString("ip");
				Timestamp rDate=rs.getTimestamp("rDate");
				dto = new BoardDto(Integer.parseInt(num), 
							writer, subject, content, email, 
							readCount, pw, ref, re_step, re_level, ip, rDate);
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
	// 조회수 올리기 readCountUp(num)
	public void readCountUp(int num) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
	public void readCountUp(String num) {
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
	// 글 수정 updateBoard(dto)
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE BOARD SET WRITER=?, "
							+ "SUBJECT=?, "
							+ "CONTENT=?, "
							+ "EMAIL=?, "
							+ "PW=?, "
							+ "IP=? "
						+ " WHERE NUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			pstmt.setInt(7, dto.getNum());
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
	// 글 삭제 deleteBoard(num, pw)	
	public int deleteBoard(int num, String pw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOARD WHERE NUM=? AND PW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
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