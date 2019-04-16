package com.tj.ex01;

public class InterfaceClass implements InterfaceEx1, InterfaceEx2{
	@Override
	public void method1() {
		System.out.println("InterfaceEx1에서 implements받아 구현함 : method1()");
	}
	@Override
	public void method2() {
		System.out.println("InterfaceEx2에서 implements받아 구현함 : method2()");
	}

}
