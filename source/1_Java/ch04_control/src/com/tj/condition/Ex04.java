package com.tj.condition;
import java.util.Scanner;
// �Է¹��� ���� ���밪 ���
public class Ex04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�Է��� ��?");
		int su = scanner.nextInt();
		//System.out.println("���밪�� "+((su>=0)? su:-1*su));
		if(su>=0) {
			System.out.println("���밪�� "+su);
		}else {
			System.out.println("���밪�� "+(-su));
		}
	}
}
