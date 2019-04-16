package com.tj.ex5equals;

public class PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9201122052144L);
		Person p2 = new Person(9201122052144L);
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 Person");
		}else {
			System.out.println("p1과 p2는 다른 Person");
		}
	}
}
