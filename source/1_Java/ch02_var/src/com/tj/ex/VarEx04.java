package com.tj.ex;
public class VarEx04 {
	public static void main(String[] args) {
		// 변수 선언 방법
		// 1. 자료형 변수명; - 선언과 할당을 분리
		int num1;
		num1 = 10;
		// 2. 자료형 변수명 = 초기값; ★ 선언과 할당(초기화)을 동시에
		int num2 = 20;
		// 3. 자료형 변수명, 변수명;
		double d1, d2;
		d1 = 3.3; d2=3.141592;
		// 4. 자료형 변수명=값, 변수명=값;
		int num3=30, num4=40, num5=50;
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		System.out.println("d1="+d1);
		System.out.println("num3="+num3+"  num4="+num4+"  num5="+num5);
	}
}
