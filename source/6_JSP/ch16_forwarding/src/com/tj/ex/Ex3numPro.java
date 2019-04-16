package com.tj.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex3numPro")
public class Ex3numPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int sum = 0;
		for(int i=1 ; i<=num; i++) {
			sum += i;
		}
		request.setAttribute("sum", sum);
		response.sendRedirect("ex3sumView.jsp");
		/*RequestDispatcher dispatcher =
			request.getRequestDispatcher("ex3sumView.jsp");
		dispatcher.forward(request, response);*/
	}
}















