package com.tj.method2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.tj.method1.Student;
public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx =
		  new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student st1 = ctx.getBean("st1", Student.class);
		Student st2 = ctx.getBean("st2", Student.class);
		System.out.println(st1);
		System.out.println(st2);
		ctx.close();
	}
}
