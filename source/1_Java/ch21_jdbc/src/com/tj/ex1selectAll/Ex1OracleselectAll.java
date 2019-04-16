package com.tj.ex1selectAll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Ex1OracleselectAll {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String query = "SELECT * FROM EMP";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);//1.����̹��ε�
			conn = DriverManager.getConnection(url, "scott", "tiger");// 2.���ᰴü ����
			stmt = conn.createStatement(); // 3.SQL������ ��ü(stmt) ����
			rs = stmt.executeQuery(query);// 4. SQL�� ����  5.����ޱ�
			if(rs.next()) { // 6.���(rs) �޾� ���ϴ� ���� ����
				do {
					int    empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job   = rs.getString("job");
					int    mgr   = rs.getInt("mgr");
					Date   hiredate = rs.getDate("hiredate");
					int    sal   = rs.getInt("sal");
					int    comm  = rs.getInt("comm");
					int    deptno= rs.getInt("deptno");
					if(job.length()>=8) {
						System.out.printf("%d\t%s\t%s\t%d\t%TF\t%d\t%d\t%d\n",
							empno, ename, job, mgr, 
							hiredate, sal, comm, deptno);
					}else {
						System.out.printf("%d\t%s\t%s\t\t%d\t%TF\t%d\t%d\t%d\n",
								empno, ename, job, mgr, 
								hiredate, sal, comm, deptno);
					}
				}while(rs.next());
			}else {
				System.out.println("�����Ͱ� �����ϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();   //7.��������
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {}
		}
	}
}
















