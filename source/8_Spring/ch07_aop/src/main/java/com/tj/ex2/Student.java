package com.tj.ex2;
public class Student {
	private String name;
	private int age;
	private int gradeNum;
	private int classNum;
	public void getStudentInfo() { // 핵심기능 = JoinPoint
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println(gradeNum+"학년 "+classNum+"반");
	}
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setGradeNum(int gradeNum) {this.gradeNum = gradeNum;}
	public void setClassNum(int classNum) {this.classNum = classNum;}
}
