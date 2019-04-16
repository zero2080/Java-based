package com.tj.homework1205;
public class Student extends Person{
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(¹Ý)"+ban);
	}
}
