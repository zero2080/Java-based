package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.EmpDto;
public class EmpDao {
	private static EmpDao instance = new EmpDao();
	private DataSource ds;	
	public static EmpDao getInstance() {
		return instance;
	}
	private EmpDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<EmpDto> list(String schEname, String schJob){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EMP "
				+ " WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schEname);
			pstmt.setString(2, "%"+schJob+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno    = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				int mgr      = rs.getInt("mgr");
				Date hiredate= rs.getDate("hiredate");
				int sal      = rs.getInt("sal");
				int comm     = rs.getInt("comm");
				int deptno   = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, 
						hiredate, sal, comm, deptno));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs   !=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
}















