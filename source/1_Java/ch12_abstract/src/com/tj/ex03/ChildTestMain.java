package com.tj.ex03;
public class ChildTestMain {
	public static void main(String[] args) {
		//SuperClass sObj = new SuperClass(); 추상클래스는 객체 생성 불가
		ChildClass cObj = new ChildClass();
		cObj.method1();
		cObj.method2();
		cObj.method3();
	}
}
