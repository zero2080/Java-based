package com.tj.ex3_student;

public class StudentExpel {
	private Student[] expels = new Student[10];
	private int index;
	public StudentExpel() {
		this.index = -1;
	}
	public void add(int hak, String name, int age, String major) {
		expels[++index]=new Student(hak, name, age, major);
	}
}
