package com.tj.ex7construct_super;
public class Baby extends Person {
	public Baby() {
		super("","");
		System.out.println("매개변수 없는 Baby 생성자");
	}
	public Baby(String name, String character) {
		// super.xxx : super클래스의 xxx
		// super()   : super클래스의 생성자. 반드시 첫라인에.
		// 원래는 암말없으면 Person()
		super(name, character); //Person(name, character)
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.println(getName()+"은 아기라서 말 못해");
	}
	public void cry() {
		System.out.println("응애응애");
	}
}
