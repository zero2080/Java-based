package com.tj.op;
// 삼항연산자(조건연산자) 
//     조건식? 조건식이 참일 경우 값:조건식이거짓일경우값
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
		String result = (h%2==0)? "짝수":"홀수";
		System.out.println(result);
		/*if(h%2==0)
			System.out.println("짝수");
		else 
			System.out.println("홀수");*/
	}
}
