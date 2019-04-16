package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date now = new Date();
		String nowStr1 = String.format
				("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분 %1$TS초", now);
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String nowStr2 = sdf.format(now.getTime());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<link href=\"css/ex1.css\" rel=\"stylesheet\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>현재 시간은 "+nowStr1+"입니다</h2>");
		out.print("<h2>현재 시간은 "+nowStr2+"입니다</h2>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
