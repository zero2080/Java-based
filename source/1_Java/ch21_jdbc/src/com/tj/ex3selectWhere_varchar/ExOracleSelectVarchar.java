package com.tj.ex3selectWhere_varchar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleSelectVarchar {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ��� �ϴ� �μ����� ?");
		String dname = sc.next();
		//String sql1 = "SELECT * FROM DEPT WHERE DNAME='"+dname+"'";
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME='%s'", dname);
		/*String sql2 = "SELECT EMPNO, ENAME, SAL, COMM, E.DEPTNO, DNAME " + 
				"FROM DEPT D, EMP E " + 
				"WHERE E.DEPTNO=D.DEPTNO AND DNAME='"+dname+"'";*/
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, COMM, E.DEPTNO, DNAME " + 
				"    FROM DEPT D, EMP E " + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME='%s'", dname);
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver); //1
			conn = DriverManager.getConnection(url, "scott", "tiger");//2
			stmt = conn.createStatement(); // 3
			rs = stmt.executeQuery(sql1); // 4+5
			if(rs.next()) { // �ش� �μ����� �ִ� ��� 6�ܰ�
				System.out.println("�μ���ȣ : "+rs.getInt("deptno"));
				System.out.println("�� �� �� : "+rs.getString("dname"));
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				// �ش� �μ��� ����� ���, �̸�, sal, comm, �μ���ȣ, �μ��� ���
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) { // �Ѹ��̻��� ����� �ִ� ���
					System.out.println("���\t�̸�\t�޿�\t��\t�μ���ȣ\t�μ���");
					System.out.println("___________________________________");
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int comm = rs.getInt("comm");
						int deptno = rs.getInt("deptno");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+
								comm+"\t"+deptno+"\t"+dname);
					}while(rs.next());
				}else {
					System.out.println("�ش� �μ����� ����� �����ϴ�");
				}
			}else {
				System.out.println("�ش� �μ����� ��ȿ���� �ʽ��ϴ�");
			}//if
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ����:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL ����:"+e.getMessage());
		}finally {
			try {  //7
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}//try-catchh-finally
	}//main
}//class


















