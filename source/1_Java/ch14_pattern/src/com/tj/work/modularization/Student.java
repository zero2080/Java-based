package com.tj.work.modularization;
import com.tj.work.inter.GetStudentPay;
import com.tj.work.inter.JobStudey;
public class Student extends Person{
	private String ban;
	public Student() {}
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudey());
		setGet(new GetStudentPay());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+ban);
	}
}
