package com.tj.ex;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class CalMainClass {
	public static void main(String[] args) {
		/*Calculation calculation = new Calculation();
		calculation.setFirstNum(10);
		calculation.setSecondNum(2);*/
		String location = "classpath:applicationCTX.xml";
		//xml파일을 파싱하여 spring컨테이너(ICO컨테이너)에 객체생성
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext(location);
		//외부(Spring컨테이너)에서 객체를 주입받아 calculation에 대입
		Calculation calculation =
				ctx.getBean("calculation",Calculation.class);
		calculation.add();
		calculation.sub();
		calculation.mul();
		calculation.div();
		ctx.close();
	}
}
