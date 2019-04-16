package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ex5")
public class Ex5 extends HttpServlet {
	private String[] colorSet = {"red", "orange", "yellow", "green",
		"blue","navy","violet"};
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int backColorIdx, fontColorIdx; 
		String backColor= request.getParameter("backColor");
		for (backColorIdx=0;backColorIdx<colorSet.length;backColorIdx++)
			if(colorSet[backColorIdx].equals(backColor))
				break;
		fontColorIdx = (backColorIdx==0)? 6 : backColorIdx-1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><style>");
		out.println("body{background-color:"+backColor+";}");
		out.println("h1{color:"+colorSet[fontColorIdx]+";}");
		out.println("</style><head>");
		out.println("<html><body>");
		out.println("<h1>글자색은 "+colorSet[fontColorIdx]+"배경색은 " + 
				backColor +"입니다");
		out.println("</h1></body></html>");
		out.close();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int backColorIdx = Integer.parseInt(request.getParameter("backColorIdx"));
		int fontcolorIdx = (backColorIdx==0)? 6:backColorIdx-1;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><style>");
		out.println("body{background-color:"+colorSet[backColorIdx]+";}");
		out.println("h1{color:"+colorSet[fontcolorIdx]+";}");
		out.println("</style></head>");
		out.println("<html><body>");
		out.println("<h1>글자색은 "+colorSet[fontcolorIdx]+", 배경색은 " + 
			colorSet[backColorIdx] +"입니다");
		out.println("</h1></body></html>");
		out.close();
	}
}





