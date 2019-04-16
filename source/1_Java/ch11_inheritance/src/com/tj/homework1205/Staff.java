package com.tj.homework1205;
public class Staff extends Person{
	private String department;
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(ºÎ¼­)"+department);
	}
}
