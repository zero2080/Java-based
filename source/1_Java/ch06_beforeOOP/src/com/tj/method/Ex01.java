package com.tj.method;

// sum(), evenOdd() ���
public class Ex01 {
	public static void main(String[] args) {
		Arithmetic tool = new Arithmetic();
		
		int tot = tool.sum(1, 50);
		System.out.println("�������� "+tot);
		System.out.println(tool.evenOdd(tot));
		
		System.out.println("-5�� ���밪�� "+tool.abs(-5));
	}
}
