package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex4")
public class Ex4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] n = request.getParameterValues("n");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<link href='css/ex3.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		if(n!=null) {
			out.println("<table>");
			out.println("<tr>");
			for(int j=0 ; j<n.length ; j++){
				out.println("<td>"+n[j]+"단</td>");
			}
			out.println("</tr>");
			for(int i=1 ; i<10 ; i++){
				out.println("<tr>");
				for(int j=0 ; j<n.length ; j++){
					out.println("<td>"+n[j]+"*"+i+"="+
							Integer.parseInt(n[j])*i+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
		}else {
			out.println("<h2>선택한 구구단수가 없습니다</h2>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}