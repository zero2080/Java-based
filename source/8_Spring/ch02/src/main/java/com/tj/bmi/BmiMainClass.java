package com.tj.bmi;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class BmiMainClass {
	public static void main(String[] args) {
		String loc = "classpath:applicationCTXbmi.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(loc);
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
		myInfo.infoOut();
		ctx.close();
	}
}
