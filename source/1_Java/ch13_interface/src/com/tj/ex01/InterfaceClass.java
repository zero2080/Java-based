package com.tj.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{
	@Override
	public void method1() {
		System.out.println("InterfaceEx1���� implements�޾� ������ : method1()");
	}
	@Override
	public void method2() {
		System.out.println("InterfaceEx2���� implements�޾� ������ : method2()");
	}

}
