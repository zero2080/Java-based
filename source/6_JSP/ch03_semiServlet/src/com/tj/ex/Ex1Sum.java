package com.tj.ex;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex1Sum")
public class Ex1Sum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex1Sum() { super(); }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// num파라미터 받아서 1~num까지 누적합을 구해 화면에 출력
		String numStr = request.getParameter("num");
		int num = Integer.parseInt(numStr);
		int total = 0;
		for(int i=1 ; i<=num ; i++) {
			total += i;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>1부터 "+num+"까지 누적합은 "+total+"</h1>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}










