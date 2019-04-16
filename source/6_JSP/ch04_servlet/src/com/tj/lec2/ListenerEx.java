package com.tj.lec2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerEx implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ch04 웹어플리케이션 메모리에서 destroy(6)");
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ch04 웹어플리케이션 Listener 가동(0)");
	}
}