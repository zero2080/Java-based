package com.tj.ex;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import javax.annotation.*;
public class Student /* implements InitializingBean, DisposableBean */ {
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {return name;}
	public int getAge() {return age;}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
	@PostConstruct
	public void postConstruct() {
		 System.out.println("막 빈이 생성되었을 때 호출됨");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("빈이 소멸되기전에 호출됨");
	}
	/*
	 * @Override public void afterPropertiesSet() throws Exception {
	 * System.out.println("막 빈이 생성되었을 때 호출됨"); }
	 * 
	 * @Override public void destroy() throws Exception {
	 * System.out.println("빈이 소멸되기전에 호출됨");
	 * }
	 */
}












