package com.tj.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
			new GenericXmlApplicationContext("applicationCTX.xml");
		Student st1 = ctx.getBean("student", Student.class);
		Student st2 = ctx.getBean("student", Student.class);
		System.out.println("st1 : "+st1);
		System.out.println("st2 : "+st2);
		st2.setName("홍홍홍");
		System.out.println("st2만 수정후");
		System.out.println("st1 : "+st1);
		System.out.println("st2 : "+st2);
	}

}
