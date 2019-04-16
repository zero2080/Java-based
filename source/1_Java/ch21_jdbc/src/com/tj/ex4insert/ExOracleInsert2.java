package com.tj.ex4insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleInsert2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		// �Է��� �μ���ȣ�� �ִ��� Ȯ�� SQL
		String sqlSelect = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sqlSelect);
			if(rs.next()) {
				System.out.println("���� �μ���ȣ�� �־ �Է� �Ұ��մϴ�");
			}else {
				System.out.print("�� �μ��� �μ�����? ");
				String dname = sc.next();
				System.out.print("�� �μ��� ��ġ�� ?");
				String loc = sc.next();
				//String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"','"+loc+"')";
				String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s','%s')", 
																  deptno, dname, loc);
				int result = stmt.executeUpdate(sql);
				if(result>0) {
					System.out.println(deptno+"�� �μ� �Է� ����");
				}				
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(deptno+"�� �μ� �Է� ����"+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
	}
}






















