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
		System.out.print("원하는 부서번호는 ?");
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
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서이름 : "+rs.getString("dname"));
				System.out.println("부서위치 : "+rs.getString("loc"));
				//   해당 부서 사원들을 출력
				rs.close();
				rs = stmt.executeQuery(sql2);//4+5
				if(rs.next()) { // 해당부서 사원이 있을 경우 6
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int sal = rs.getInt("sal");
						int comm = rs.getInt("comm");
						Date hiredate = rs.getDate("hiredate");
						System.out.println(empno+"\t"+ename+"\t"+sal+"\t"+comm+
								"\t"+hiredate);
					}while(rs.next());
				}else { // 해당 부서번호의 사원이 없을 경우
					System.out.println("해당 부서번호의 사원은 업습니다");
				}// emp 출력
			}else {
				System.out.println("해당 부서번호가 없습니다.");
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











