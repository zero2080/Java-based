package com.tj.ex5;

public class OverridingTest {
	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		ChildClass  c = new ChildClass();
		p.method1();
		p.method2();
		//p.method3();
		c.method1();
		c.method2();
		c.method3(); c.method3(10);
	}
}
