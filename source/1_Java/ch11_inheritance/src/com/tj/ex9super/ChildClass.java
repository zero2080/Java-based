package com.tj.ex9super;
public class ChildClass extends ParentClass {
	private int i=1;
	@Override
	public void method() {
		System.out.println("�ڽ��� method()");
		super.method();
		System.out.println("i="+i+"\t�θ�Ŭ������ i="+getI());
	}
	public void method_1() {
		super.method();
	}
}
