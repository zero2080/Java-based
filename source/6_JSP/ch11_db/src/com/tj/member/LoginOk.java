package com.tj.member;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String uid    = "scott";
		String upw    = "tiger";
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String query = "SELECT * FROM MEMBER WHERE ID=? AND PW=?";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 로그인 성공
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("name", rs.getString("name"));
				httpSession.setAttribute("id", id);
				httpSession.setAttribute("pw", pw);
				httpSession.setAttribute("phone1", rs.getString("phone1"));
				httpSession.setAttribute("phone2", rs.getString("phone2"));
				httpSession.setAttribute("phone3", rs.getString("phone3"));
				httpSession.setAttribute("gender", rs.getString("gender"));
				httpSession.setAttribute("validMem", "yes");
				response.sendRedirect("lec3_member/loginResult.jsp");
			}else { // 로그인 실패
				response.sendRedirect("lec3_member/login.jsp?msg=idPwCheck");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}



















