package com.tj.method4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tj.method1.Student;
public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
		  new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student st1 = ctx.getBean("st1", Student.class);
		Student st2 = ctx.getBean("st2", Student.class);
		System.out.println(st1);
		System.out.println(st2);
		ctx.close();
	}
}
