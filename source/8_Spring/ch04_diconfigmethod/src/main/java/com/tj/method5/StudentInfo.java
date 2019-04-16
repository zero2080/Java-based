package com.tj.method5;
import org.springframework.beans.factory.annotation.Autowired;
public class StudentInfo {
	@Autowired
	private Student student;
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
}
