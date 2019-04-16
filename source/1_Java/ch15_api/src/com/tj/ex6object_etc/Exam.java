package com.tj.ex6object_etc;

public class Exam {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(5, 10);
		Class cls = obj.getClass();
		System.out.println(cls.getName());
		Class superCls = cls.getSuperclass();
		System.out.println(superCls);
	}
}
