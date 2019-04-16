package com.tj.ex03;
public class ChildClass extends SuperClass/*, SuperClass2*/{
	public ChildClass() {
		System.out.println("ChildClass의 생성자");
	}
	@Override
	public void method1() {
		System.out.println("ChildClass이 꼭 오버라이드해야할 method1");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass이 궂지 오버라이드한 method2");
	}
	public void method3() {
		System.out.println("ChildClass이 새로 추가한 method3");
	}
}
