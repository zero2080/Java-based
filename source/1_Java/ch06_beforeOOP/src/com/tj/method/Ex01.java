package com.tj.method;

// sum(), evenOdd() 사용
public class Ex01 {
	public static void main(String[] args) {
		Arithmetic tool = new Arithmetic();
		
		int tot = tool.sum(1, 50);
		System.out.println("누적합은 "+tot);
		System.out.println(tool.evenOdd(tot));
		
		System.out.println("-5의 절대값은 "+tool.abs(-5));
	}
}
