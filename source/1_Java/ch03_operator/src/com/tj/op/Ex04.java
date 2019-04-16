package com.tj.op;
// 논리연산자 && || ,& |,  !
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=100;
		System.out.println("((i>j) && (++j>h)) = "+( (i>j) && (++j>h)) );
		System.out.println("j="+j);
		System.out.println("((i<j) || (++j>h)) = "+( (i<j) || (++j>h)) );
		System.out.println("j="+j);
		// 비트 and(&), 비트 or(|)
		int n1 = 10; // 0000 1010
		int n2 = 5 ; // 0000 0101
		System.out.println(n1 & n2);
		System.out.println(n1 | n2);
		System.out.println(n1 ^ n2); // 비트별 다르면 1
		System.out.println(n2 >> 1); // shift연산자
		
		// !(not)
		System.out.println(!(n1==n2));
	}
}
