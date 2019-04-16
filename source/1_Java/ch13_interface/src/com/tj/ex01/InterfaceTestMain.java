package com.tj.ex01;

public class InterfaceTestMain {
	public static void main(String[] args) {
		//InterfaceEx1 obj = new InterfaceEx1(); 인터페이스는 객체 생성불가
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1(); // O 
		obj1.method2(); // O
		InterfaceEx1 obj2 = new InterfaceClass();
		// 인터페이스는 객체 생성 불가. 변수 타입으로만 가능(객체 타입으로만 가능)
		obj2.method1(); // O
		//obj2.method2(); // X
		InterfaceEx2 obj3 = new InterfaceClass();
		//obj3.method1(); // X
		obj3.method2();
		System.out.println(obj1.CONSTANT_NUM); // O
		System.out.println(obj1.CONSTANT_STRING);//O
		System.out.println(obj2.CONSTANT_NUM); // O - InterfaceEx1내의 상수이므로
		//System.out.println(obj2.CONSTANT_STRING);
		//System.out.println(obj3.CONSTANT_NUM);
		System.out.println(obj3.CONSTANT_STRING);
	}
}









