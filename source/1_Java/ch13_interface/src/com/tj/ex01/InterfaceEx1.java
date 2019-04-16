package com.tj.ex01;
public interface InterfaceEx1 {
	public /*static final*/ int CONSTANT_NUM = 100;
	public /*abstract*/ void method1();
	public default void x() {
		System.out.println("default method2() - 예외");
	}
	public static void xx() {
		System.out.println("static method3() - 예외");
	}
}
