package com.tj.lec1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ex1methodTest")
public class Ex1methodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex1methodTest() {super();}
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	out.println("<html><body>");
    	out.println("<h1>service()실행함</h1>");
    	out.println("</body></html>");
		out.close();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>전달받은 파라미터 a = "+a+"</h2>");
		out.println("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
