package com.tj.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Ex3PreparedUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		Statement         stmt  = null;
		ResultSet         rs    = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �μ���ȣ?");
		int deptno = sc.nextInt();
		String selectSql = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String updateSql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			if(rs.next()) {
				System.out.print("������ �μ���?");
				String dname = sc.next();
				System.out.print("������ �μ���ġ?");
				String loc = sc.next();
				pstmt = conn.prepareStatement(updateSql);
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				int result = pstmt.executeUpdate();
				System.out.println(result>0 ? "���� ����":"��������");
			}else {
				System.out.println("���� �μ���ȣ�Դϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {}
		}
	}
}