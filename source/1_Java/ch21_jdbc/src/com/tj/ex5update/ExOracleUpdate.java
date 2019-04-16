package com.tj.ex5update;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleUpdate {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ��� �ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�� �μ��� �����ϰ��� �ϴ� �μ����� ?");
		String dname = sc.next();
		System.out.print("�� �μ��� �����ϰ��� �ϴ� ��ġ�� ?");
		String loc = sc.next();
		/*String sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d",
													dname, loc, deptno);*/
		String sql = "UPDATE DEPT SET DNAME='"+dname+"', LOC='"+loc+"' WHERE DEPTNO="+deptno;
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
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}















