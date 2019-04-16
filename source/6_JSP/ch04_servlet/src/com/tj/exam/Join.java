package com.tj.exam;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		//Timestamp b = Timestamp.valueOf(birth);
		//Date bb = Date.valueOf(birth);
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/join.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinForm_wrap'>");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<h2>hiddenParam : "+hiddenParam+"</h2>");
		out.println("<h2>이름 : "+name+"</h2>");
		out.println("<h2>아이디 : "+id+"</h2>");
		out.println("<h2>비번 : ");
		for(int i=0 ; i<pw.length() ; i++)
			out.print('*');
		out.println("</h2>");
		out.println("<h2>생년월일 : "+birth+"</h2>");
		out.println("<h2>취미 : ");
		for(int i=0 ; i<hobby.length ; i++)
			if(i==hobby.length-1)
				out.print(hobby[i]);
			else
				out.print(hobby[i]+", ");
		out.println("</h2>");
		out.println("<h2>성별 : "+gender+"</h2>");
		out.println("<h2>이메일 : "+email+"</h2>");
		out.println("<h2>메일수신동의 : ");
		if(mailSend!=null) {
			for(int i=0 ; i<mailSend.length ; i++) {
				if(i==mailSend.length-1)
					out.print(mailSend[i]);
				else
					out.print(mailSend[i]+", ");
			}
		}else {
			out.print("모두 메일 수신 거부");
		}
		out.println("</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}