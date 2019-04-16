package com.tj.ex03overloading;

public class TestMain {
	public static void main(String[] args) {
		OverloadingTest obj2 = new OverloadingTest(1);
		OverloadingTest obj3 = new OverloadingTest(1,2);
		obj2.calculate();
		obj3.calculate();
		obj2.calculate("Hello");
	}
}
