package com.tj.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Ex2PreparedSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String query  = "SELECT * FROM DEPT";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(query);
			// query 에 ?가 있으면 ? 채워넣고(setXXX(inex, 값)) 전송
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					String loc   = rs.getString("loc");
					System.out.println(deptno+"\t"+dname+"\t"+loc);
				}while(rs.next());
			}else {
				System.out.println("해당 데이터가 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {}
		}
	}
}
