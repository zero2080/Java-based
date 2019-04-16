package com.tj.ex;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Homework")
public class Homework extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String schJob  = request.getParameter("schJob"); 
		if(schName== null) schName = "";
		if(schJob == null) schJob = "";
		EmpDao empDao = new EmpDao();
		ArrayList<EmpDto> dtos = empDao.getEmps(schName, schJob);
		request.setAttribute("emps", dtos);
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("homework/emps.jsp");
		dispatcher.forward(request, response);
	}
}

















