package com.tj.ex4_finalVar;
// final 변수 - 초기화 된 값 변경 불가 
public class FinalVarTest {
	public static void main(String[] args) {
		final double PI = 3.141592;
		// PI = 3.14; final변수는 변경불가
		double r = 3;
		double area = PI*r*r;
		double round = 2*PI*r;
		System.out.println("반지름이 "+r+"인 원의 넓이는 "+area);
		System.out.println("반지름이 "+r+"인 원의 둘레는 "+round);
	}
}
