package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloWorld() {
        super();
    }
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println("Hello~World");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>h1{color:red; text-align:center;}</style>");
		out.println("</head>");
		out.println("<body>");
		for(int i=0 ; i<2 ; i++)
			out.println("<h1>Hello, World</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}









