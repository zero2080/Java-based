package com.tj.ex7construct;
public class Baby extends Person {
	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		System.out.println("매개변수 있는 Baby 생성자");
		setName(name);
		setCharacter(character);
	}
	@Override
	public void intro() {
		System.out.println(getName()+"은 아기라서 말 못해");
	}
	public void cry() {
		System.out.println("응애응애");
	}
}
