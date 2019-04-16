package com.tj.ex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class EmpDao {
	private Connection getConnection() throws SQLException {
		Connection conn=null;
		Context ctx;
		try {
			ctx = new InitialContext();
			DataSource ds = 
					(DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public ArrayList<EmpDto> getEmps(String schName, String schJob){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EMP "
				+ "WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schName.toUpperCase());
			pstmt.setString(2, schJob.toUpperCase());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	public ArrayList<EmpDto> getEmps(){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM EMP";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				dtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
}