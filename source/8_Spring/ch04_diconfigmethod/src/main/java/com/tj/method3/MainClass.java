package com.tj.method3;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.tj.method1.Student;
public class MainClass {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX3.xml";
		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext(location);
		Student st1 = ctx.getBean("st1", Student.class);
		Student st2 = ctx.getBean("st2", Student.class);
		System.out.println(st1);
		System.out.println(st2);
		ctx.close();
	}
}















