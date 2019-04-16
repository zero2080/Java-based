package com.tj.ex4insert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է��� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�� �μ��� �μ����� ?");
		String dname = sc.next();
		System.out.print("�� �μ��� ��ġ�� ?");
		String loc = sc.next();
		//String sql = "INSERT INTO DEPT VALUES ("+deptno+", '"+dname+"','"+loc+"')";
		String sql = String.format("INSERT INTO DEPT VALUES (%d, '%s','%s')", 
														  deptno, dname, loc);
		Connection conn = null;
		Statement  stmt = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url, "scott", "tiger");//2
			stmt = conn.createStatement(); //3
			int result = stmt.executeUpdate(sql); //4+5
			if(result>0) { //6
				System.out.println(deptno+"�μ���ȣ �Է� ����");
			}else {
				System.out.println(deptno+"�μ���ȣ �Է� ����");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {}
		}
	}
}






















