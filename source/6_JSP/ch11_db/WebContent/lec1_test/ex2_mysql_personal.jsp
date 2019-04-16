<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection, java.sql.Statement"%>
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
		String driverM = "com.mysql.jdbc.Driver";
		String urlM    = "jdbc:mysql://127.0.0.1:3306/kimdb";
		String uidM    = "root";
		String upwM    = "mysql";
		Connection conn;
		Statement  stmt;
		ResultSet  rs;
		String sql = "SELECT * FROM personal";
	%>
	<%
		try{
			Class.forName(driverM);
			conn = DriverManager.getConnection(urlM, uidM, upwM);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			out.println("<table><tr><th>사번</th><th>이름</th><th>입사일</th></tr>");
			while(rs.next()){
				int pno = rs.getInt("pno");
				String pname = rs.getString("pname");
				Date startdate = rs.getDate("startdate");
				out.print("<tr><td>"+pno+"</td><td>"+pname+"</td><td>"
																								+startdate+"</td></tr>");
			}
			out.print("</table>");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(rs!=null)   rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}
	%>
</body>
</html>















