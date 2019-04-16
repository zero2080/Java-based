package com.tj.ex;
import java.util.Scanner;
// 3! = 3*2*1
public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 ! 계산할까?");
		int su = sc.nextInt();
		System.out.println(factorial(su));
	}
	public static long factorial(int su) { // 재귀적 호출을 이용한 method
		// 1! = 1
		// 2! = 2 * 1!
		// 3! = 3 * 2!
		// 4! = 4 * 3!
		// n! = n * (n-1)!
		if(su==1) {
			return 1;
		}else {
			return su * factorial(su-1);
		}		
	}
	/*public static long factorial(int su) { // su*(su-1)*(su-2)* ... *2 * 1
		long result = 1;
		for(int i=su ; i>=1 ; i--) {
			result *= i; //result = result * i;
		}
		return result;
	}*/
}
