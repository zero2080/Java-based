package com.tj.method3;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tj.method1.Student;
@Configuration
public class ApplicationConfig {
	@Bean
	public Student st1() {
		ArrayList<String> hobby = new ArrayList<String>();
		hobby.add("놀기");hobby.add("자기");
		Student st = new Student("김갑돌", 30, hobby);
		st.setHeight(180);
		st.setWeight(65);
		return st;
	}
}
