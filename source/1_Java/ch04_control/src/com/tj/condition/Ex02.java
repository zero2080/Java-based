package com.tj.condition;
import java.util.Scanner;
// �μ��� �Է¹޾� ū���� �󸶳� �� ū�� ���
public class Ex02 {
	public static void main(String[] args) {
		int num1, num2;
		Scanner scanner = new Scanner(System.in);
		System.out.print("ù��° ���� ? ");
		num1 = scanner.nextInt();
		System.out.print("�ι�° ���� ? ");
		num2 = scanner.nextInt();
		if(num1>num2) {
			System.out.println("ū���� "+num1+" �μ��� ����"+(num1-num2));
		}else if(num2>num1){
			System.out.println("ū���� "+num2+" �μ��� ���� "+(num2-num1));
		}else {
			System.out.println("�μ��� ����");
		}
	}
}