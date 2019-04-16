package com.tj.ex4objectNthreadN;

public class ObjectNthreaNTest {
	public static void main(String[] args) {
		Thread theadA = new ThreadExtendCls();
		Thread theadB = new ThreadExtendCls();
		Thread theadC = new ThreadExtendCls();
		theadA.setName("A");
		theadB.setName("B");
		theadC.setName("C");
		theadA.start();
		theadB.start();
		theadC.start();
	}
}
