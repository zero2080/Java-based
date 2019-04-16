package com.tj.ex1selectAll;
import java.sql.*;
public class Ex2MySQLselectAll {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String     sql  = "SELECT * FROM PERSONAL";
		try {
			Class.forName(driver);// 1
			conn = DriverManager.getConnection(url, "root", "mysql");//2
			stmt = conn.createStatement(); // 3
			rs = stmt.executeQuery(sql); // 4+5
			if(rs.next()) {  // 6
				do{
					int    pno   = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job   = rs.getString("job");
					int    manager = rs.getInt("manager");
					Timestamp startdate = rs.getTimestamp("startdate");
					int    pay   = rs.getInt("pay");
					int    bonus = rs.getInt("bonus");
					int    dno   = rs.getInt("dno");
					System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"
							+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
				}while(rs.next());
			}else {
				System.out.println("데이터가 없습니다");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로드:"+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL"+e.getMessage());
		}finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) { }
		}
	}
}
