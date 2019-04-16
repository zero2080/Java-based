package com.tj.op;
// 산술연산자 예제 * / + - %(나머지연산자)
public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result = n1 + n2;
		System.out.printf("%d %c %d = %d\n", n1, '+', n2, result);
		result = n1 - n2;
		System.out.printf("%d %c %d = %d\n", n1, '-', n2, result);
		result = n1 * n2;
		System.out.printf("%d %c %d = %d\n", n1, '*', n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n", n1, '/', n2, result);
		double doubleResult = n1/(double)n2;
		System.out.printf("%d %c %d = %f\n", n1, '/', n2, doubleResult);
		doubleResult = n1 / 0.0;
		System.out.printf("%d %c %f = %f\n", n1, '/', 0.0, doubleResult);
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n", n1, '%', n2, result);
		if((n1%5)==0)
			System.out.println("n1은 5의 배수입니다");
		else
			System.out.println("n1은 5의 배수가 아닙니다");
	}
}
