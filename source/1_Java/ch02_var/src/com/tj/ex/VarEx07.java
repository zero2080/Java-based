package com.tj.ex;

public class VarEx07 {
	public static void main(String[] args) {
		// 묵시적인 형변환 = 작은 주머니값을 큰 주머니로 할당할 때
		int i = 10; 
		double d = i;
		// 명시적인 형변환 = 큰 주머니값을 작은 주머니로 할당할 때(데이터 손실, 코드명시)
		i = (int)10.9;
		System.out.printf("i=%d \t d=%f", i, d);
	}
}
