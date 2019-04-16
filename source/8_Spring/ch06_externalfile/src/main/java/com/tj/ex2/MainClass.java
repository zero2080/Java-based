package com.tj.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext("applicationCTX2.xml");
		Info info = ctx.getBean("info", Info.class);
		System.out.println(info.getAdminId());
		System.out.println(info.getAdminPw());
		System.out.println(info.getSub_adminId());
		System.out.println(info.getSub_adminPw());
	}
}
