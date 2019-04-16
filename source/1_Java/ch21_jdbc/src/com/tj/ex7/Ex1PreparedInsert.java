package com.tj.ex7;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Ex1PreparedInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String query  = "INSERT INTO DEPT VALUES (?, ?, ?)";

		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�Է��� �μ����� ?");
		String dname = sc.next();
		System.out.print("�Է��� �μ���ġ�� ?");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deptno); // 1��° ?�� �� setting : deptno(int)
			pstmt.setString(2, dname);// 2��° ?�� �� setting : dname(String)
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "�Է¼���":"�Է½���");			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
}











