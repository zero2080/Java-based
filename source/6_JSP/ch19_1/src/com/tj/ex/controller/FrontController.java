package com.tj.ex.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.service.MemberJoinService;
import com.tj.ex.service.MembersAllService;
import com.tj.ex.service.Service;
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = ""; // jsp(VIEW)단으로 갈 페이지 경로
		Service service = null;
		if(command.equals("/joinForm.do")) {
			viewPage = "member/join.jsp";
		}else if(command.equals("/joinMember.do")) {
			service = new MemberJoinService();
			service.execute(request, response);
			viewPage ="member/joinResult.jsp";
		}else if(command.equals("/membersAll.do")) {
			service = new MembersAllService();
			service.execute(request, response);
			viewPage = "member/membersAll.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}