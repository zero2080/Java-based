package com.tj.singleton1;

public class MainClass {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass();
		SecondClass secondObj = new SecondClass();
		SingletonClass singObj = SingletonClass.getSingletonClass();
		System.out.println("main�Լ������� singObj�� i��");
		System.out.println(singObj.getI());		
	}
}
