package com.tj.vehicle;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		String loc = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(loc);
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);
		vehicle.ride("홍길동");
		ctx.close();
	}
}
