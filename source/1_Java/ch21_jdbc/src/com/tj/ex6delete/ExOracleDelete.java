package com.tj.ex6delete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleDelete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ��� �ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		String sql = "DELETE FROM DEPT WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(deptno+"�� �μ� ���� ����");
			}else {
				System.out.println(deptno+"�� �μ��� ��� ���� ����");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
}





