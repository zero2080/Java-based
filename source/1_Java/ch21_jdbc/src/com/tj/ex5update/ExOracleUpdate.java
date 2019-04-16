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
		System.out.print("수정하고자 하는 부서번호는 ?");
		int deptno = sc.nextInt();
		System.out.print("그 부서의 수정하고자 하는 부서명은 ?");
		String dname = sc.next();
		System.out.print("그 부서의 수정하고자 하는 위치는 ?");
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
				System.out.println(deptno+"번 부서 수정 성공");
			}else {
				System.out.println(deptno+"번 부서는 없어서 수정 실패");
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















