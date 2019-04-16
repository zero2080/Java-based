package com.tj.member;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String hyunPw = request.getParameter("hyunPw");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender = request.getParameter("gender");
		HttpSession session = request.getSession();
		String sessionPw = (String)session.getAttribute("pw");
		if(sessionPw.equals(hyunPw)) {
			// 현재 비밀번호 맞게  입력해서 수정 진행
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String uid    = "scott";
			String upw    = "tiger";
			Connection        conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE MEMBER SET NAME=?, PW=?, PHONE1=?, "
										+ "PHONE2=?, PHONE3=?, GENDER=?"
						+ " WHERE ID=?";
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
				pstmt.setString(3, phone1);
				pstmt.setString(4, phone2);
				pstmt.setString(5, phone3);
				pstmt.setString(6, gender);
				pstmt.setString(7, id);
				int result = pstmt.executeUpdate();
				if(result>0) { // 수정성공 => 세션데이터수정, modifyResult.jsp로 
					System.out.println("회원정보 수정");
					session.setAttribute("name", name);
					session.setAttribute("pw", pw);
					session.setAttribute("phone1", phone1);
					session.setAttribute("phone2", phone2);
					session.setAttribute("phone3", phone3);
					session.setAttribute("gender", gender);
					response.sendRedirect("lec3_member/modifyResult.jsp?result=ok");
				}else { // 수정실패 => modifyResult.jsp
					response.sendRedirect("lec3_member/modifyResult.jsp?result=no");
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {}
			}
		}else {//현재 비밀번호를 틀리게 입력해서 다시 modify로
			response.sendRedirect("lec3_member/modify.jsp?msg=n");
		}
	}
}
























