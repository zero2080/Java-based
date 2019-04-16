package com.tj.singleton1;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonObject 
							= SingletonClass.getSingletonClass();
		System.out.println("FirstClass에서의 SingletonObject의 i값");
		System.out.println(singletonObject.getI());
		singletonObject.setI(200);
		System.out.println("i="+singletonObject.getI());
	}
}
