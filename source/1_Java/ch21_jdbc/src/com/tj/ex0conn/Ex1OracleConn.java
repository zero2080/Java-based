package com.tj.ex0conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Ex1OracleConn {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		try {
			Class.forName(driver);// ① 드라이버로드
			System.out.println("드라이버 로드 성공");
			conn = DriverManager.getConnection(url, "scott", "tiger");
					// ② 연결 객체 생성
			System.out.println("연결 객체 생성도 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 예외 :"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("연결 예외 : "+e.getMessage());
		}finally {
			try {
				if(conn!=null) conn.close(); // ⑦ 연결해제
			}catch (Exception e) { }
		}

	}
}
