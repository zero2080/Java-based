package com.tj.work.modularization;
import com.tj.work.inter.GetSalary;
import com.tj.work.inter.JobLec;
public class Staff extends Person{
	private String park;
	public Staff(String id, String name, String park) {
		super(id, name);
		this.park = park;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+park);
	}
}
