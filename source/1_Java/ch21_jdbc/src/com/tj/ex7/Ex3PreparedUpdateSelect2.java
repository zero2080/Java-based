package com.tj.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Ex3PreparedUpdateSelect2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO=?";
		String updateSql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호?");
		int deptno = sc.nextInt();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.print("수정할 부서명?");
				String dname = sc.next();
				System.out.print("수정할 부서위치?");
				String loc = sc.next();
				pstmt.close();
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "수정 성공":"수정실패");
			}else {
				System.out.println("없는 부서번호입니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
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
