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
		System.out.print("검색하고자 하는 부서명은 ?");
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
			if(rs.next()) { // 해당 부서명이 있는 경우 6단계
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부 서 명 : "+rs.getString("dname"));
				System.out.println("부서위치 : "+rs.getString("loc"));
				// 해당 부서명 사원의 사번, 이름, sal, comm, 부서번호, 부서명 출력
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) { // 한명이상의 사원이 있는 경우
					System.out.println("사번\t이름\t급여\t상여\t부서번호\t부서명");
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
					System.out.println("해당 부서명의 사원은 없습니다");
				}
			}else {
				System.out.println("해당 부서명은 유효하지 않습니다");
			}//if
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL 오류:"+e.getMessage());
		}finally {
			try {  //7
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}//try-catchh-finally
	}//main
}//class


















