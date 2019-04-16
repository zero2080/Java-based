package com.tj.homework1205;
public class Person {
	private String id;
	private String name;
	public Person() {}
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void print() {
		System.out.print("(ID)"+id+"\t(¿Ã∏ß)"+name);
	}
}