<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");%>
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
		Connection conn;
		PreparedStatement pstmt;
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?)";
	%>
	<%
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String pw   = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, phone1);
			pstmt.setString(5, phone2);
			pstmt.setString(6, phone3);
			pstmt.setString(7, gender);
			int result = pstmt.executeUpdate();
			//System.out.println(result>0? "회원가입성공":"회원가입실패");
			if(result>0){
				System.out.println("회원가입성공");
				session.setAttribute("id", id);
				response.sendRedirect("joinResult.jsp?result=ok");
			}else{
				System.out.println("회원가입실패");
				response.sendRedirect("joinResult.jsp?result=no");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("회원가입실패");
			response.sendRedirect("joinResult.jsp?result=no");
		}finally{
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	%>
</body>
</html>














