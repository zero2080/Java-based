package com.tj.ex.frontController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tj.ex.service.BContentService;
import com.tj.ex.service.BDeleteService;
import com.tj.ex.service.BListService;
import com.tj.ex.service.BModifyService;
import com.tj.ex.service.BModifyViewService;
import com.tj.ex.service.BReplyService;
import com.tj.ex.service.BReplyViewService;
import com.tj.ex.service.BService;
import com.tj.ex.service.BWriteService;
@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int write_view = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println("uri:"+uri+"/conPath:"+conPath+"/command:"+command);
		String viewPage = null;
		BService service = null;
		if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "mvcboard/list.jsp";
		}else if(command.equals("/write_view.do")) {
			write_view = 1;
			viewPage = "mvcboard/write_view.jsp";
		}else if(command.equals("/write.do")) {
			if(write_view == 1) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = 0;
			}
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "mvcboard/content_view.jsp";
		}else if(command.equals("/modify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "mvcboard/modify_view.jsp";
		}else if(command.equals("/modify.do")) {
			service = new BModifyService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {
			service = new BDeleteService();
			service.execute(request, response);
			viewPage = "list.do";
		}else if(command.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "mvcboard/reply_view.jsp";
		}else if(command.equals("/reply.do")) {
			service = new BReplyService();
			service.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}