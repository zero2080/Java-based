<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {background-color: blue; margin: 0 auto;}
		caption{padding:10px;}
		th,td {padding : 10px; text-align: center; background-color: white;}
	</style>
</head>
<body>
	<%!
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String uid    = "scott";
		String upw    = "tiger";
		Connection conn;
		Statement  stmt;
		ResultSet  rs;
		String sql = "SELECT * FROM MEMBER";
	%>
	<table>
		<caption>회원 리스트</caption>
		<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>전화번호</th></tr>
	<%
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				do{
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					out.print("<tr><td>"+id+"</td><td>"+pw+"</td><td>"+
										name+"</td><td>"+phone+"</td></tr>");
				}while(rs.next());
			}else{
				out.print("<tr><td colspan='4'>가입한 회원이 없습니다</td></tr>");
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




















