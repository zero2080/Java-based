package com.tj.ex;
public class Student {
	private int studentNum;
	private String name;
	private int grade;
	private int score;
	public Student() {}
	public Student(int studentNum, String name, int grade, int score) {
		this.studentNum = studentNum;
		this.name = name;
		this.grade = grade;
		this.score = score;
	}
	public int getStudentNum() {return studentNum;}
	public void setStudentNum(int studentNum) {this.studentNum = studentNum;}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
