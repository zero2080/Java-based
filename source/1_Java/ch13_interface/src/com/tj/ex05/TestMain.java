package com.tj.ex05;

public class TestMain {
	public static void main(String[] args) {
		TestChild test = new TestChild();
		System.out.println(TestChild.IN1);
		System.out.println(Inew1.IN1);
		//Inew1.IN1 = 10;
		test.m1();
		test.m2();
		test.new_m1();
	}
}
