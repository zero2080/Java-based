package com.tj.ex.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.ALoginService;
import com.tj.ex.service.BContentService;
import com.tj.ex.service.BDeleteService;
import com.tj.ex.service.BListService;
import com.tj.ex.service.BModifyService;
import com.tj.ex.service.BModifyViewService;
import com.tj.ex.service.BReplyService;
import com.tj.ex.service.BReplyViewService;
import com.tj.ex.service.BWriteService;
import com.tj.ex.service.MAllViewService;
import com.tj.ex.service.MJoinService;
import com.tj.ex.service.MLoginService;
import com.tj.ex.service.MLogoutService;
import com.tj.ex.service.MModifyService;
import com.tj.ex.service.Service;
@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int write_view = 0;
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
		Service service = null;
		/* * member 관련 요청들 * * * * * * * * * * * * */
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
			viewPage = "list.do";
		}else if(com.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/allView.do")) {
			/* * admin 로그인 성공시 나오는 화면 * */
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/main.do")) {
			viewPage = "main/main.jsp";
		}else if(com.equals("/list.do")) {/* * fileBoard 관련 요청들 */
			service = new BListService();
			service.execute(request, response);
			viewPage = "fileboard/list.jsp";
		}else if(com.equals("/write_view.do")) {
			write_view = 1;
			viewPage = "fileboard/write_view.jsp";
		}else if(com.equals("/write.do")) {
			if(write_view == 1) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = 0;
			}
			viewPage = "list.do";
		}else if(com.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "fileboard/content_view.jsp";
		}else if(com.equals("/boradModify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "fileboard/modify_view.jsp";
		}else if(com.equals("/boradModify.do")) {
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/delete.do")) {
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "fileboard/reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/adminloginView.do")) { /*** admin ******/
			viewPage = "admin/adminLogin.jsp";
		}else if(com.equals("/adminLogin.do")) {
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}