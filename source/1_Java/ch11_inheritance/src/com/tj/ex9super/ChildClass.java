package com.tj.ex9super;
public class ChildClass extends ParentClass {
	private int i=1;
	@Override
	public void method() {
		System.out.println("자식의 method()");
		super.method();
		System.out.println("i="+i+"\t부모클래스의 i="+getI());
	}
	public void method_1() {
		super.method();
	}
}
