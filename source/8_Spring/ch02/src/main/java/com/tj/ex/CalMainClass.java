package com.tj.ex;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class CalMainClass {
	public static void main(String[] args) {
		String resourceLocation ="classpath:applicationCTX.xml";
		// xml을 파싱하여 bean객체 생성
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(resourceLocation);
		// 객체 주입받음
		MyCalculation myCalculation = 
				ctx.getBean("myCalculation", MyCalculation.class);
		myCalculation.add();
		myCalculation.sub();
		myCalculation.mul();
		myCalculation.div();
		ctx.close();
	}
}
