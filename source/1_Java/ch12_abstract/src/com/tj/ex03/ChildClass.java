package com.tj.ex03;
public class ChildClass extends SuperClass/*, SuperClass2*/{
	public ChildClass() {
		System.out.println("ChildClass�� ������");
	}
	@Override
	public void method1() {
		System.out.println("ChildClass�� �� �������̵��ؾ��� method1");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass�� ���� �������̵��� method2");
	}
	public void method3() {
		System.out.println("ChildClass�� ���� �߰��� method3");
	}
}
