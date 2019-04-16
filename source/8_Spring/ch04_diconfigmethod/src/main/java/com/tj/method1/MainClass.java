package com.tj.method1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String loc1 = "classpath:applicationCTX1.xml";
		String loc2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(loc1, loc2);
		Student st1 = ctx.getBean("st1", Student.class);
		StudentInfo info = ctx.getBean("studentInfo",StudentInfo.class);
		Student st3 = ctx.getBean("st3", Student.class);
		Student st2 = info.getStudent();
		if(st1.equals(st2)) {
			System.out.println("st1이랑 st2는 같네");
		}
		info.setStudent(st3);
		if(info.getStudent().equals(st2)) {
			System.out.println("info의 student랑 st2는 같네");
		}
		Family family = ctx.getBean("family", Family.class);
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(family);
		ctx.close();
	}
}














