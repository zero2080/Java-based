package com.tj.op;
// �������� && || ,& |,  !
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=100;
		System.out.println("((i>j) && (++j>h)) = "+( (i>j) && (++j>h)) );
		System.out.println("j="+j);
		System.out.println("((i<j) || (++j>h)) = "+( (i<j) || (++j>h)) );
		System.out.println("j="+j);
		// ��Ʈ and(&), ��Ʈ or(|)
		int n1 = 10; // 0000 1010
		int n2 = 5 ; // 0000 0101
		System.out.println(n1 & n2);
		System.out.println(n1 | n2);
		System.out.println(n1 ^ n2); // ��Ʈ�� �ٸ��� 1
		System.out.println(n2 >> 1); // shift������
		
		// !(not)
		System.out.println(!(n1==n2));
	}
}
