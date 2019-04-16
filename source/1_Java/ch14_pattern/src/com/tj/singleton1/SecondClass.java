package com.tj.singleton1;

public class SecondClass {
	public SecondClass() {
		SingletonClass singletonObject 
			= SingletonClass.getSingletonClass();
		System.out.println("SecondClass °´Ã¼¿¡¼­ i°ª");
		System.out.println(singletonObject.getI());
	}
}
