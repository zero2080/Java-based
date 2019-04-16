package com.tj.method5;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext("applicationCTX5.xml");
		StudentInfo info = ctx.getBean("studentInfo",StudentInfo.class);
		System.out.println(info.getStudent());
		ctx.close();
	}
}