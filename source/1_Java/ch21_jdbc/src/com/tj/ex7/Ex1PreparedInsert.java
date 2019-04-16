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
		System.out.print("입력할 부서번호는 ?");
		int deptno = sc.nextInt();
		System.out.print("입력할 부서명은 ?");
		String dname = sc.next();
		System.out.print("입력할 부서위치는 ?");
		String loc = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, deptno); // 1번째 ?의 값 setting : deptno(int)
			pstmt.setString(2, dname);// 2번째 ?의 값 setting : dname(String)
			pstmt.setString(3, loc);
			int result = pstmt.executeUpdate();
			System.out.println(result>0? "입력성공":"입력실패");			
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











