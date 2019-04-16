package com.tj.ex.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.MAllViewService;
import com.tj.ex.service.MGetMemberService;
import com.tj.ex.service.MJoinService;
import com.tj.ex.service.MLoginService;
import com.tj.ex.service.MLogoutService;
import com.tj.ex.service.MModifyService;
import com.tj.ex.service.MService;
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri     = request.getRequestURI();
		String conPath = request.getContextPath();
		String com     = uri.substring(conPath.length()); //들어온 요청
		String viewPage = null;
		MService service = null;
		if(com.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(com.equals("/join.do")) {
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(com.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(com.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/modifyView.do")) {
			//service = new MGetMemberService();
			//service.execute(request, response);
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}