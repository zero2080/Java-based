package com.tj.lec1;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LifeCycle() { super(); }
    @PostConstruct
    public void postCons() {
    	System.out.println("막 생성되었을 때 (1)");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()호출-메모리에서 서블릿 생성(2)");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출 (3)");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
	}
	public void destroy() {
		System.out.println("destroy()호출-메모리에서 destory될 때 (4)");
	}
	@PreDestroy
	public void preDes() {
		System.out.println("지금 곧 destory 됨 (5)");
	}
}
