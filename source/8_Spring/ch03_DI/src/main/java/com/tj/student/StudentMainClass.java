package com.tj.student;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class StudentMainClass {
	public static void main(String[] args) {
		String resourceLoc = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(resourceLoc);
		Student student = ctx.getBean("student", Student.class);
		
		StudentInfo studentInfo = 
				ctx.getBean("studentInfo",StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		if(student.equals(student2)) {
			System.out.println("둘은 같네");
		}else {
			System.out.println("둘은 다르네");
		}
		studentInfo.getStudentInfo();
		//
		Student student3 = ctx.getBean("student3", Student.class);
		studentInfo.setStudent(student3);
		if(student3.equals(student2)) {
			System.out.println("둘은 같네");
		}else {
			System.out.println("둘은 다르네");
		}
		studentInfo.getStudentInfo();
		ctx.close();
	}
}










