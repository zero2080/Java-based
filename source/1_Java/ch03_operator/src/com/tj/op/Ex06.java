package com.tj.op;
// �Ҵ� ������ =, +=, -=, *=, /=, %=
public class Ex06 {
	public static void main(String[] args) {
		int n1 = 10*3; // n1==30
		n1 += 10; // n1 = n1 + 10; n1==40
		n1 -= 10; // n1 = n1-10;
		n1 *= 10; // n1 = n1*10;
		n1 /= 10; // n1 = n1/10;
		n1 %= 10; // n1 = n1%10;
		
		n1 += 1;
		++n1;
	}
}
