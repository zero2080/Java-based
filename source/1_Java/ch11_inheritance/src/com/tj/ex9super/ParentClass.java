package com.tj.ex9super;
public class ParentClass {
	private int i=99;
	public ParentClass() {System.out.println("ParentClass 생성자");}
	public void method() {System.out.println("부모의 method()");}
	public int getI() {
		return i;
	}
}