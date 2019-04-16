package com.tj.ex;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex2GuguOut")
public class Ex2Gugu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex2Gugu() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int su = Integer.parseInt(request.getParameter("su"));
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>"+su+"단 구구단입니다</h1>");
		for(int i=1 ; i<10 ; i++) {
			out.println("<h2>"+su+"*"+i+"="+(su*i)+"</h2>");
		}		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}








