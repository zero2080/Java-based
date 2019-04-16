package com.tj.method4;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.tj.method1.Student;
@Configuration
@ImportResource("classpath:applicationCTX4.xml")
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
