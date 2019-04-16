<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String uid    = "scott";
		String upw    = "tiger";
		String driverM = "com.mysql.jdbc.Driver";
		String urlM    = "jdbc:mysql://127.0.0.1:3306:kimdb";
		String uidM    = "root";
		String upwM    = "mysql";
		Connection conn;
		Statement  stmt;
		ResultSet  rs;
		String sql = "SELECT * FROM EMP";
	%>
	<table>
		<caption>EMP테이블</caption>
		<tr><th>사번</th><th>이름</th><th>직책</th><th>입사일</th></tr>
	<%
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job   = rs.getString("job");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				out.print("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job
						+"</td><td>"+hiredate+"</td></tr>");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	%>
	</table>
</body>
</html>




















