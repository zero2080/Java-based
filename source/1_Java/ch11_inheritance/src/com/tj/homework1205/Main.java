package com.tj.homework1205;
public class Main {
	public static void main(String[] args) {
		Person st1 = new Student("A01","강유미","JAVA반");
		Person st2 = new Student("A02","홍길동","C++");
		Person sf1 = new Gangsa("S01","유길동","운영지원팀");
		Person sf2 = new Gangsa("S02","유한동","취업지원팀");
		Person ga1 = new Staff("G01","이길동","객체지향");
		Person[] p = {st1, st2, sf1, sf2, ga1};
		for(Person pp : p)
			pp.print();
	}
}
