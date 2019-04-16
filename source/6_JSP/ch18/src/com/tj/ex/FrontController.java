package com.tj.ex;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		Service service;
		if(command.equals("/insert.do")) {
			System.out.println("insert 호출됨");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>들어온 요청은 insert</h1>");
			out.print("<h1>"+command+"</h1>");
			out.close();
		}else if(command.equals("/select.do")) {
			System.out.println("select 호출됨");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>들어온 요청은 select</h1>");
			out.print("<h1>"+command+"</h1>");
			out.close();
		}else if(command.equals("/update.do")) {
			System.out.println("update 호출됨");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>들어온 요청은 update</h1>");
			out.print("<h1>"+command+"</h1>");
			out.close();
		}else if(command.equals("/delete.do")) {
			System.out.println("delete 호출됨");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<h1>들어온 요청은 delete</h1>");
			out.print("<h1>"+command+"</h1>");
			out.close();
		}else if(command.equals("/membersAll.do")) {
			service = new MembersAllService();
			ArrayList<MemberDto> members = service.execute(request, response);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("<table>");
			for(int i=0 ; i<members.size() ; i++) {
				out.print("<tr><td>"+members.get(i).getId()+"</td>");
				out.print("<td>"+members.get(i).getPw()+"</td>");
				out.print("<td>"+members.get(i).getName()+"</td>");
				out.print("<td>"+members.get(i).getEmail()+"</td>");
				out.print("<td>"+members.get(i).getBirth().toString().substring(0, 10)+"</td>");
				out.print("<td>"+members.get(i).getAddress()+"</td>");
				out.print("<td>"+members.get(i).getrDate()+"</td></tr>");
			}
			out.print("</table>");
			out.print("</body></html>");
			out.close();
		}else if(command.equals("/memberJoin.do")) {
			service = new MemberJoinService();
			service.execute(request, response);
			int result = (int)request.getAttribute("joinResult");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			if(result==MemberDao.SUCCESS) {
				out.print("<h1>회원가입성공</h1>");
			}else {
				out.print("<h1>회원가입실패</h1>");
			}
			out.print("</body></html>");
			out.close();
		}
	}
}
























