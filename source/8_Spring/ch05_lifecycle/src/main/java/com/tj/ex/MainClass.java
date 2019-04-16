package com.tj.ex;
import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		// 스프링컨테이너 생성 - 컨테이너 관련 환경까지 셋팅되고 저장
		GenericXmlApplicationContext ctx =
			new GenericXmlApplicationContext(); 
		// 빈이 생성
		ctx.load("classpath:applicationCTX.xml");ctx.refresh();
		// 빈 주입받음
		Student student = ctx.getBean("student", Student.class);
		// 사용
		System.out.println(student);
		// 스프링컨테이너 소멸 : 그안의 bean들, 환경변수 모두 소멸
		ctx.close();
	}
}
