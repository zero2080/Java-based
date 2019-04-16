package com.tj.lec1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex2ArrayParam")
public class Ex2ArrayParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex2ArrayParam() {super();}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h2>선택한 메뉴는 ");
		if(menu == null) {
			out.println(" 없습니다");
		}else {
			for(String m : menu) {
				out.println(m + " &nbsp; ");
			}
		}
		out.println("</h2><h2>선택한 식당 동네는 ");
		if(rest==null) {
			out.println("없습니다");
		}else {
			for(String r : rest) {
				out.println(r +" &nbsp; ");
			}
		}
		out.println("</h2><h2>선택한 국적은 "+nation+"</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}









