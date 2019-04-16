package com.tj.ex13.dao;
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

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.tj.ex13.dto.BoardDto;
import com.tj.ex13.util.Constant;
public class BoardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private JdbcTemplate template;
	private DataSource ds; // ★
	public BoardDao() {
		template = Constant.template;
		try {
			Context ctx = new InitialContext();
			ds = 
			(DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}// ★
	}
	// 글목록
	public ArrayList<BoardDto> list(int startRow, int endRow){
		String sql = "SELECT * FROM " + 
				" (SELECT ROWNUM RN, A.* FROM " + 
				"   (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP) A)" + 
				" WHERE RN BETWEEN "+startRow+" AND "+endRow;
		ArrayList<BoardDto> dtos =
			(ArrayList<BoardDto>) 
		template.query(sql, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
		return dtos;
	}
	// 글갯수
	public int getBoardTotCnt() {
		String sql = "SELECT COUNT(*) cnt FROM MVC_BOARD";
		return template.queryForInt(sql);
	}
	// 글쓰기(원글쓰기)
	public int write(final String bname, final String btitle, 
			final String bcontent, final String bip) {
		String sql = "INSERT INTO MVC_BOARD"
		+ " (bId, bName, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP)"
		+ " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, "
		+ "            MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				pstmt.setString(4, bip);
			}
		});			
	}
	// 조회수올리기
	private void hitUp(int bid) {
		String sql = "UPDATE MVC_BOARD SET BHIT = BHIT+1 WHERE BID="+bid;
		template.update(sql);
	}
	// 글 상세보기(조회수 up + bid로 dto리턴)
	public BoardDto contentView(int bid) {
		hitUp(bid);
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, 
				new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 답변글 view + 수정 view (bid로 dto리턴)
	public BoardDto modifyView_replyView(int bid) {
		String sql = "SELECT * FROM MVC_BOARD WHERE BID="+bid;
		return template.queryForObject(sql, 
				new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	// 글 수정하기(bname, btitle, bcontent, bip, bid)
	public int modify(final int bid, final String bname, final String btitle, 
			final String bcontent,	final String bip) {
		String sql = "UPDATE MVC_BOARD "
				+ "SET BNAME=?, "
					+ "BTITLE = ?, "
					+ "BCONTENT = ?, "
					+ "BIP = ?, "
					+ "BDATE = SYSDATE "
				+ "WHERE BID=?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bname);
				ps.setString(2, btitle);
				ps.setString(3, bcontent);
				ps.setString(4, bip);
				ps.setInt(5, bid);
			}
		});
	}
	// 글 삭제하기(bid로 글 삭제하기)
	public int delete(int bid) {
		String sql = "DELETE FROM MVC_BOARD WHERE BID="+bid;
		return template.update(sql);
	}	
	// step a
	private void preReplyStepA(final int bgroup, final int bstep) {
		String sql = "UPDATE MVC_BOARD SET BSTEP = BSTEP+1 "
				+ " WHERE BGROUP = ? AND BSTEP>?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, bgroup);
				ps.setInt(2, bstep);
			}
		});
	}
	// 답변글 쓰기
	public int reply(final String bname, final String btitle,
			final String bcontent, final String bip,
			final int bgroup, final int bstep, final int bindent) {
		preReplyStepA(bgroup, bstep); // 답변글 저장전 step A 먼저 실행
		// bgroup, bstep, bindent 원글정보
		// bname, btitle, bcontent, bip 답변글 정보
		String sql = "INSERT INTO MVC_BOARD "
			+ "(BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) "
			+ " VALUES (MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, bname);
				pstmt.setString(2, btitle);
				pstmt.setString(3, bcontent);
				pstmt.setInt(4, bgroup);
				pstmt.setInt(5, bstep+1);
				pstmt.setInt(6, bindent+1);
				pstmt.setString(7, bip);
			}
		});
	}
}






