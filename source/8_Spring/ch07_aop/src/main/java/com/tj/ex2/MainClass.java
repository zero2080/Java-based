package com.tj.ex2;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(resourceLocation);
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		System.out.println("------------------------------");
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
		ctx.close();
	}
}