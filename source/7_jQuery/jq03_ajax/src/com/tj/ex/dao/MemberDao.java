package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class MemberDao {
	public static final int EXISTENT    = 0;
	public static final int NONEXISTENT = 1;
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
}