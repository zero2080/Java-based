package com.tj.op;
// 증감연산자 : ++(1씩 증가) --(1씩 감소)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = n1++;
		//n1=11 , n2=10
		System.out.printf("1. n1=%d, n2=%d\n", n1, n2);
		int n3 = 10;
		System.out.printf("2. n3=%d\n", n3++);
		System.out.printf("3. n3=%d\n", n3);
		n3 =100;
		System.out.printf("4. %d %d %d %d\n", n3++, ++n3, n3--, --n3);
		System.out.printf("5. n3 = %d", n3);
	}
}
