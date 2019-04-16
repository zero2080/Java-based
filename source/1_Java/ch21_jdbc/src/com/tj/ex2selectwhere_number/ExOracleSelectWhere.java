package com.tj.ex2selectwhere_number;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ExOracleSelectWhere {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		//String sql1 = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
		String sql1 = String.format("SELECT * FROM DEPT WHERE DEPTNO=%d", deptno);
		String sql2 = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		try {
			Class.forName(driver);//1
			conn = DriverManager.getConnection(url, "scott", "tiger");//2
			stmt = conn.createStatement();//3
			rs = stmt.executeQuery(sql1);//4+5
			if(rs.next()) { //6
				System.out.println("�μ���ȣ : "+rs.getInt("deptno"));
				System.out.println("�μ��̸� : "+rs.getString("dname"));
				System.out.println("�μ���ġ : "+rs.getString("loc"));
				//   �ش� �μ� ������� ���
				rs.close();
				rs = stmt.executeQuery(sql2);//4+5
				if(rs.next()) { // �ش�μ� ����� ���� ��� 6
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int comm = rs.getInt("comm");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+comm+
								"\t"+hiredate);
					}while(rs.next());
				}else { // �ش� �μ���ȣ�� ����� ���� ���
					System.out.println("�ش� �μ���ȣ�� ����� �����ϴ�");
				}// emp ���
			}else {
				System.out.println("�ش� �μ���ȣ�� �����ϴ�.");
			}//dept
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}//try
	}//main
}//class











