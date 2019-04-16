package com.tj.ex0conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Ex2MySQLconn {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb";
		Connection conn = null;
		try {
			Class.forName(driver);// 1단계 : 드라이버 로드
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "root", "mysql");
			// 2단계 : 연결객체
			System.out.println("연결객체 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn!=null) conn.close();
			}catch(SQLException e) {}
		}
	}
}
