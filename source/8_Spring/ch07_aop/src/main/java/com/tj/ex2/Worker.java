package com.tj.ex2;
public class Worker {
	private String name;
	private int age;
	private String job;
	public void getWorkerInfo() { // 핵심기능 - JoinPoint
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("직업 : "+job);
	}
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setJob(String job) {this.job = job;}
}
