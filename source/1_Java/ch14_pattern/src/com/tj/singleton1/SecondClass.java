package com.tj.singleton1;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject 
			= SingletonClass.getSingletonClass();
		System.out.println("SecondClass ��ü���� i��");
		System.out.println(singletonObject.getI());
	}
}
