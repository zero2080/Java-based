package com.tj.op;
// 동등비교(관계) 연산자 < <= > >=
public class Ex03 {
	public static void main(String[] args) {
		int n1=10, n2=25;
		boolean result = n1 < n2;
		// %s(문자열) %d(정수) %f(실수) %c(문자) %x(16진수) %b(불린)
		System.out.printf("%d %c %d = %b\t", n1, '<', n2, result);
		result = n1 > n2;
		System.out.printf("%d %c %d = %b\n", n1, '>', n2, result);
		result = n1 <= n2;
		System.out.printf("%d %s %d = %b\n", n1, "<=", n2, result);
		result = n1 >= n2;
		System.out.printf("%d %s %d = %b\n", n1, ">=", n2, result);
		// 같다(==) 다르다(!=)
		System.out.println(n1==n2);
		System.out.println(n1!=n2);
	}
}
