package com.tj.homework1205;
public class Gangsa extends Person{
	private String subject;
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(°ú¸ñ)"+subject);
	}
}
