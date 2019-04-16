package com.tj.method2;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//스프링 설정 파일임을 뜻하는 어노테이션
import com.tj.method1.Student;
import com.tj.method1.StudentInfo;
@Configuration 
public class ApplicationConfig {
	// 빈 생성 - id(name), class
	@Bean
	public Student st1() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("마라톤");
		hobby.add("요가");
		Student st = new Student("김갑순", 25, hobby);
		st.setWeight(55);
		st.setHeight(155);
		return st;
	}
	@Bean
	public Student st2() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("수영");
		hobby.add("요가");
		Student st = new Student("홍길동", 25, hobby);
		st.setWeight(65);
		st.setHeight(175);
		return st;
	}
}


















